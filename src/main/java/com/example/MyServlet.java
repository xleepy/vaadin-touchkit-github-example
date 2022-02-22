package com.example;

import com.example.data.remote.Credentials;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import org.vaadin.touchkit.server.TouchKitServlet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet
public class MyServlet extends TouchKitServlet implements SessionInitListener, SessionDestroyListener {

    private final MyUIProvider uiProvider = new MyUIProvider();
    private final Credentials credentials = Credentials.getInstance();


    public Object readJNDI(String paramName) throws NamingException {
        Object jndiValue = null;
        final InitialContext ic = new InitialContext();
        jndiValue = ic.lookup("java:comp/env/" + paramName);
        return jndiValue;
    }

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(this);
        getService().addSessionDestroyListener(this);
    }


    @Override
    public void sessionDestroy(SessionDestroyEvent sessionDestroyEvent) {
        sessionDestroyEvent.getSession().removeUIProvider(uiProvider);
    }

    @Override
    public void sessionInit(SessionInitEvent event) {
        System.out.println("Loading " + event.getRequest().getPathInfo());
        event.getSession().addUIProvider(uiProvider);
//        // JETTY
//        try {
//            credentials.setClientId((String)readJNDI("client_id"));
//            credentials.setClientSecret((String) readJNDI("client_secret"));
//            credentials.setToken((String) readJNDI("token"));
//            System.out.println(readJNDI("client_id"));
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        // HEROKU
//        try{
//            credentials.setClientId(System.getenv("CLIENT_ID"));
//            credentials.setClientSecret(System.getenv("CLIENT_SECRET"));
//            credentials.setToken(System.getenv("TOKEN"));
//        }catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
}
