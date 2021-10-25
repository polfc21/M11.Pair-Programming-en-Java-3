package com.nivel3.controller.floristMenu;

import com.nivel3.controller.Controller;
import com.nivel3.view.utils.Session;

public class ChooseStockController extends Controller{
	
	public ChooseStockController(Session session) {
		super(session);
	}
	
	public void control() {
		this.session.stockMenu();
	}

}
