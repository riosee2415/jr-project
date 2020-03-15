package com.patis.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		session.setAttribute("loginRight", 5);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {}

}
