package com.example.ui.repository;

import com.example.MyNavigationView;
import com.example.data.models.repository.File;
import com.example.data.remote.stores.RepositoryDetailStore;
import com.vaadin.event.LayoutEvents;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import io.reactivex.Observable;
import org.vaadin.touchkit.ui.VerticalComponentGroup;

import java.util.List;

public class Directory extends MyNavigationView {
    VerticalComponentGroup content = new VerticalComponentGroup();
    private final String userLogin;
    private final RepositoryDetailStore repositoryDetailStore;
    private final Observable<List<File>> files;
    private final String repositoryName;

    public Directory(String userLogin, String repositoryName, RepositoryDetailStore detailStore, Observable<List<File>> files) {
        setCaption(repositoryName);
        this.userLogin = userLogin;
        this.repositoryDetailStore = detailStore;
        this.files = files;
        this.repositoryName = repositoryName;
    }

    @Override
    public void attach() {
        super.attach();
        subscribe(files, (files) -> {
            for (File file : files) {
                content.addComponent(createGridLayoutForFile(file, repositoryDetailStore, repositoryName, userLogin));
            }
            return null;
        });
        setContent(content);
    }

    private GridLayout createGridLayoutForFile(File file, RepositoryDetailStore store, String repositoryName, String userLogin) {
        GridLayout gridLayout = new GridLayout(1, 7);
        if ("file".equals(file.getType())) {
            gridLayout.addLayoutClickListener((LayoutEvents.LayoutClickListener) layoutClickEvent -> {
                getNavigationManager().navigateTo(
                        new FilePreview(
                                file.getName(),
                                userLogin,
                                repositoryName,
                                file.getPath()
                        )
                );
            });
        }
        if ("dir".equals(file.getType())) {
            gridLayout.addLayoutClickListener((LayoutEvents.LayoutClickListener) layoutClickEvent -> {
                getNavigationManager().navigateTo(
                        new Directory(
                                userLogin,
                                repositoryName,
                                store,
                                store.getDirectoryFiles(userLogin, repositoryName, file.getPath())
                        ));
            });
        }
        gridLayout.addComponents(new Label("Name: " + file.getName()), new Label("Size: " + file.getSize()), new Label("Type: " + file.getType()));
        return gridLayout;
    }
}
