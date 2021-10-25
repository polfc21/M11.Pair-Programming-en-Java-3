package com.nivel3.controller.addProdMenu;

import java.util.HashMap;
import java.util.Map;

import com.nivel3.controller.Controller;
import com.nivel3.controller.ExitToFloristMenuController;
import com.nivel3.view.Menu;
import com.nivel3.view.addProdMenu.*;
import com.nivel3.view.utils.Command;
import com.nivel3.view.utils.ExitToFloristMenuCommand;
import com.nivel3.view.utils.Session;

public class AddMenuController extends Controller {
	
	private CreateTreeController createTreeController;
	private CreateTreeCommand createTreeCommand;
	private CreateFlowerController createFlowerController;
	private CreateFlowerCommand createFlowerCommand;
	private CreateDecorationController createDecorationController;
	private CreateDecorationCommand createDecorationCommand;
	private ExitToFloristMenuController exitToFloristMenuController;
	private ExitToFloristMenuCommand exitToFloristMenuCommand;
	
	private Map<Command, Controller> controllers;
	private Menu menu;
	
	public AddMenuController(Session session) {	
		super(session);
		this.controllers = new HashMap<Command, Controller>();

		this.createTreeController = new CreateTreeController(this.session);
		this.createTreeCommand = new CreateTreeCommand();
		this.createFlowerController = new CreateFlowerController(this.session);
		this.createFlowerCommand = new CreateFlowerCommand();
		this.createDecorationController = new CreateDecorationController(this.session);
		this.createDecorationCommand = new CreateDecorationCommand();
		this.exitToFloristMenuController = new ExitToFloristMenuController(this.session);
		this.exitToFloristMenuCommand = new ExitToFloristMenuCommand();
			
		this.controllers.put(createTreeCommand, createTreeController);
		this.controllers.put(createFlowerCommand, createFlowerController);
		this.controllers.put(createDecorationCommand, createDecorationController);
		this.controllers.put(exitToFloristMenuCommand, exitToFloristMenuController);

		this.menu = new Menu(this.controllers.keySet());
	}	
	public void control() {
		this.createTreeCommand.setActive(true);
		this.createFlowerCommand.setActive(true);
		this.createDecorationCommand.setActive(true);
		this.exitToFloristMenuCommand.setActive(true);

		this.controllers.get(this.menu.execute()).control();

	}
}

