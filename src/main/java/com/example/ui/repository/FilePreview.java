package com.example.ui.repository;

import com.example.MyNavigationView;
import com.example.data.remote.stores.file.FileStore;
import com.vaadin.ui.TextArea;
import org.vaadin.touchkit.ui.VerticalComponentGroup;

public class FilePreview extends MyNavigationView {
    FileStore fileStore = new FileStore();
    TextArea textArea = new TextArea();
    private final String userName;
    private final String repoName;
    private final String path;

    public FilePreview(String name, String userName, String repoName, String path) {
        setCaption(name);
        this.userName = userName;
        this.repoName = repoName;
        this.path = path;

    }

    @Override
    public void attach() {
        super.attach();
        VerticalComponentGroup group = new VerticalComponentGroup();
        textArea.setWordWrap(true);
        textArea.setReadOnly(true);
        textArea.setSizeFull();

        subscribe(fileStore.loadFile(userName, repoName, path), (body) -> {
            String fileContent = fileStore.readFile(body);
            textArea.setValue(fileContent);
            return null;
        });
        group.setWidthUndefined();
        group.setHeight("100%");
        group.addStyleName("file-preview");
        group.addComponent(textArea);
        setContent(group);
    }
}
