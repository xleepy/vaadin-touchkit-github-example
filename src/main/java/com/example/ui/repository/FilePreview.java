package com.example.ui.repository;

import com.example.MyNavigationView;
import com.example.data.remote.stores.file.FileStore;
import com.vaadin.ui.TextArea;

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
    public void attach() {
        super.attach();
        textArea.setSizeFull();
        textArea.setWordWrap(true);
        textArea.setReadOnly(true);
        subscribe(fileStore.loadFile(userName, repoName, path), (body) -> {
            String fileContent = fileStore.readFile(body);
            String[] rows = fileContent.split("\\n");
            textArea.setRows(rows.length);
            textArea.setValue(fileContent);
            return null;
        });
        setContent(textArea);
    }
}
