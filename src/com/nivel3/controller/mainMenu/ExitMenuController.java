package com.nivel3.controller.mainMenu;

import com.nivel3.controller.Controller;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

public class ExitMenuController extends Controller{
	
	public ExitMenuController(Session session) {
		super(session);
	}
	
	public void control() {
		ShowInfoWindow.showInfo("SALIENDO DE LA APP...");
		this.session.exit();
	}
}
