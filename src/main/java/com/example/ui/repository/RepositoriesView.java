package com.example.ui.repository;

import com.example.MyNavigationView;
import com.example.data.models.repository.Repository;
import com.example.data.remote.stores.RepositoryDetailStore;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.vaadin.touchkit.ui.NavigationView;
import org.vaadin.touchkit.ui.VerticalComponentGroup;

import java.util.List;

public class RepositoriesView extends MyNavigationView {
    private final RepositoryDetailStore store = new RepositoryDetailStore();

    public RepositoriesView(String caption , Observable<List<Repository>> loadedRepositories) {
        setCaption(caption);
        VerticalComponentGroup content = new VerticalComponentGroup();
        Disposable disposable = loadedRepositories.subscribeOn(Schedulers.io()).subscribe(repositories -> {
            getUI().access(() -> {
                for (Repository rep : repositories) {
                    content.addComponent(createGridLayout(rep));
                }
            });
        });
        compositeDisposable.add(disposable);
        CssLayout cssLayout = new CssLayout(content);
        cssLayout.setStyleName("form");
        setContent(cssLayout);
    }

    private GridLayout createGridLayout(Repository rep) {
        GridLayout grid = new GridLayout(3, 7);
        grid.addComponent(new Label("Repository name: " + rep.getName()), 0, 0);
        if (rep.getDescription() != null) {
            grid.addComponent(new Label("Description: " + rep.getDescription()), 0, 1);
        }
        if (rep.getForksCount() != null) {
            grid.addComponent(new Label("Forks count: " + rep.getForksCount()), 0, 2);
        }
        if (rep.getWatchersCount() != null) {
            grid.addComponent(new Label("Watchers count: " + rep.getWatchersCount()), 0, 3);
        }
        grid.addComponent(new Label("Default branch" + rep.getDefaultBranch()), 0, 4);
        grid.addComponent(new Label("User name: " + rep.getUser().getLogin()), 0, 5);
        Image avatar = new Image("User avatar", new ExternalResource(rep.getUser().getAvatarUrl()));
        avatar.setWidth("100px");
        avatar.setHeight("100px");
        grid.addLayoutClickListener((LayoutEvents.LayoutClickListener) layoutClickEvent -> {
            String userLogin = rep.getUser().getLogin();
            String repositoryName = rep.getName();
            getNavigationManager().navigateTo(new Directory(userLogin, repositoryName, store, store.getRepoFiles(userLogin, repositoryName)));
        });
        grid.addComponent(avatar, 0, 6);
        grid.setStyleName("repositories");
        return grid;
    }

}
