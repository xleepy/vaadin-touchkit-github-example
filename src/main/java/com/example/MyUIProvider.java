package com.example;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class MyUIProvider extends UIProvider {

    @Override
    public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {

        boolean mobileUserAgent = event.getRequest().getHeader("user-agent")
                .toLowerCase().contains("mobile");
        boolean mobileParameter = event.getRequest().getParameter("mobile") != null;
//        if(event.getRequest().getAttribute("login") == null) {
//            return LoginView.class;
//        }
        if (overrideMobileUA() || mobileUserAgent || mobileParameter) {
//            if(event.getRequest().getAttribute("login") == null) {
//                return LoginUI.class;
//            }
            return MyTouchKitUI.class;
        } else {
            return MyFallbackUI.class;
        }
    }

    private boolean overrideMobileUA() {
        VaadinSession session = VaadinSession.getCurrent();
        return session != null && session.getAttribute("mobile") != null;
    }
}
