package com.example;

import com.example.data.remote.Credentials;
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
    private final MyPersistToServerRpc serverRpc = new MyPersistToServerRpc() {
        @Override
        public void persistToServer() {
            // TODO this method is called from client side to store offline data
        }
    };

    @Override
    protected void init(VaadinRequest request) {
        setContent(new MyTabBar());
        System.out.println("TOKEN: " + Credentials.getInstance().getToken());
        System.out.println("CLIENT_ID: " + Credentials.getInstance().getClientId());
        System.out.println("CLIENT_SECRET: " + Credentials.getInstance().getClientSecret());

//        // Use of the OfflineMode connector is optional.
//        OfflineMode offlineMode = new OfflineMode();
//        offlineMode.extend(this);
//        // Maintain the session when the browser app closes.
//        offlineMode.setPersistentSessionCookie(false);
//        // Define the timeout in secs to wait when a server request is sent
//        // before falling back to offline mode.
//        offlineMode.setOfflineModeTimeout(15);
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


