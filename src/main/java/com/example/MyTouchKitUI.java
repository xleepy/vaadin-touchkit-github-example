package com.example;

import com.example.gwt.client.MyPersistToServerRpc;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * The UI's "main" class
 */
@Push
@SuppressWarnings("serial")
@Theme("mytheme")
@PreserveOnRefresh
@Widgetset("com.example.gwt.MyWidgetSet")
public class MyTouchKitUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        setContent(new MyTabBar());
    }

    @Override
    public UI getUI() {
        return super.getUI();
    }

    @Override
    protected void refresh(VaadinRequest request) {
        super.refresh(request);
    }

}


