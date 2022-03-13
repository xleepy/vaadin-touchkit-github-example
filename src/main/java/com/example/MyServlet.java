package com.example;

import com.example.services.SubscribtionBusService;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import org.vaadin.touchkit.server.TouchKitServlet;
import com.vaadin.server.SessionInitListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(asyncSupported = true)
public class MyServlet extends TouchKitServlet  implements  SessionDestroyListener {

    private final MyUIProvider uiProvider = new MyUIProvider();

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener((SessionInitListener) event -> event.getSession().addUIProvider(uiProvider));
    }


    @Override
    public void sessionDestroy(SessionDestroyEvent sessionDestroyEvent) {
        SubscribtionBusService.getInstance().unsubscribeAll();
    }
}
