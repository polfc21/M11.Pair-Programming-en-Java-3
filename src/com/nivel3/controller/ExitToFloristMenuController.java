package com.nivel3.controller;

import com.nivel3.view.utils.Session;

public class ExitToFloristMenuController extends Controller {

	public ExitToFloristMenuController(Session session) {
		super(session);
	}
	
	public void control() {
		this.session.floristMenu();
	}
	
}
