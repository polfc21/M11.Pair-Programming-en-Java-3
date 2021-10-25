package com.nivel3.controller.floristMenu;

import com.nivel3.controller.Controller;
import com.nivel3.view.utils.Session;

public class RemoveProductController extends Controller{
	public RemoveProductController(Session session) {
		super(session);
	}
	
	public void control() {
		this.session.removeMenu();
	}
}
