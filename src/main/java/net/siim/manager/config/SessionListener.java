package net.siim.manager.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(7200);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    }
}
