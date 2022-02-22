package com.example.ui.repository;

import com.example.MyNavigationView;
import com.example.data.remote.stores.file.FileStore;
import com.example.utils.CallbackWrapper;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.TextArea;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;



public class FilePreview extends MyNavigationView {
    FileStore fileStore = new FileStore();
    TextArea textArea = new TextArea();
    private final String userName;
    private final String repoName;
    private final String path;

    public FilePreview(String name, String userName, String repoName, String path) {
        setCaption(name);
        setSizeFull();
        this.userName = userName;
        this.repoName = repoName;
        this.path = path;

    }

    @Override
    protected void onBecomingVisible() {
        super.onBecomingVisible();
        textArea.setSizeFull();
        textArea.setWordWrap(true);
        textArea.setReadOnly(true);
        Disposable disposable = fileStore.loadFile(userName, repoName, path).subscribeOn(Schedulers.io()).subscribeWith(new CallbackWrapper<ResponseBody>() {
            @Override
            public void onNext(ResponseBody o) {
                String fileContent = fileStore.readFile(o);
                getUI().access(() -> {
                    String[] rows = fileContent.split("\\n");
                    textArea.setRows(rows.length);
                    textArea.setValue(fileContent);

                });
            }
        });
        compositeDisposable.add(disposable);
        setContent(textArea);
    }
}
