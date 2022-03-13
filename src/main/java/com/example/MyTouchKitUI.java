package com.example;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import org.vaadin.touchkit.annotations.OfflineModeEnabled;

/**
 * The UI's "main" class
 */
@Push
@Theme("mytheme")
@PreserveOnRefresh
@Widgetset("com.example.gwt.MyWidgetSet")
@OfflineModeEnabled(false)
public class MyTouchKitUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        setContent(new MyTabBar());
    }

    @Override
    protected void refresh(VaadinRequest request) {
        super.refresh(request);
    }
}


