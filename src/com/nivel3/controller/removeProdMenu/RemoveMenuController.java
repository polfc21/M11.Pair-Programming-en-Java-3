package com.nivel3.controller.removeProdMenu;

import java.util.HashMap;
import java.util.Map;

import com.nivel3.controller.Controller;
import com.nivel3.controller.ExitToFloristMenuController;
import com.nivel3.view.Menu;
import com.nivel3.view.removeProdMenu.*;
import com.nivel3.view.utils.Command;
import com.nivel3.view.utils.ExitToFloristMenuCommand;
import com.nivel3.view.utils.Session;

public class RemoveMenuController extends Controller{
	private RemoveTreeController removeTreeController;
	private RemoveTreeCommand removeTreeCommand;
	private RemoveFlowerController removeFlowerController;
	private RemoveFlowerCommand removeFlowerCommand;
	private RemoveDecorationController removeDecorationController;
	private RemoveDecorationCommand removeDecorationCommand;
	private ExitToFloristMenuController exitToFloristMenuController;
	private ExitToFloristMenuCommand exitToFloristMenuCommand;
	
	private Map<Command, Controller> controllers;
	private Menu menu;
	
	public RemoveMenuController(Session session) {	
		super(session);
		this.controllers = new HashMap<Command, Controller>();

		this.removeTreeController = new RemoveTreeController(this.session);
		this.removeTreeCommand = new RemoveTreeCommand();
		this.removeFlowerController = new RemoveFlowerController(this.session);
		this.removeFlowerCommand = new RemoveFlowerCommand();
		this.removeDecorationController = new RemoveDecorationController(this.session);
		this.removeDecorationCommand = new RemoveDecorationCommand();
		this.exitToFloristMenuController = new ExitToFloristMenuController(this.session);
		this.exitToFloristMenuCommand = new ExitToFloristMenuCommand();
			
		this.controllers.put(removeTreeCommand, removeTreeController);
		this.controllers.put(removeFlowerCommand, removeFlowerController);
		this.controllers.put(removeDecorationCommand, removeDecorationController);
		this.controllers.put(exitToFloristMenuCommand, exitToFloristMenuController);

		this.menu = new Menu(this.controllers.keySet());
	}	
	public void control() {
		this.removeTreeCommand.setActive(true);
		this.removeFlowerCommand.setActive(true);
		this.removeDecorationCommand.setActive(true);
		this.exitToFloristMenuCommand.setActive(true);

		this.controllers.get(this.menu.execute()).control();

	}
}


