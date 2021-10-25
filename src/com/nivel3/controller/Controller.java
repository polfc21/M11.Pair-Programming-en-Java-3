package com.nivel3.controller;

import com.nivel3.view.utils.Session;

public abstract class Controller {
	
	protected Session session;
	
	public Controller(Session session) {
		this.session = session;
	}
	
	public abstract void control();
}
