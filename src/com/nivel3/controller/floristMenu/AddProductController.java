package com.nivel3.controller.floristMenu;

import com.nivel3.controller.Controller;
import com.nivel3.view.utils.Session;


public class AddProductController extends Controller {
	
	public AddProductController(Session session) {
		super(session);
	}
	
	public void control() {
		this.session.addMenu();
	}
	
}
