package com.nivel3.controller.floristMenu;

import com.nivel3.controller.Controller;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

public class ExitFloristMenuController extends Controller {
	
	public ExitFloristMenuController(Session session) {
		super(session);
		
	}
	
	public void control() {
		ShowInfoWindow.showInfo("VOLVIENDO AL MENU PRINCIPAL...");
		this.session.mainMenu();
	}

}
