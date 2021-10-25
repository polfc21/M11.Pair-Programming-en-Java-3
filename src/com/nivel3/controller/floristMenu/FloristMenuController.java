package com.nivel3.controller.floristMenu;

import java.util.HashMap;
import java.util.Map;

import com.nivel3.controller.Controller;
import com.nivel3.controller.mainMenu.ChooseFloristController;
import com.nivel3.view.Menu;
import com.nivel3.view.floristMenu.*;
import com.nivel3.view.mainMenu.ChooseFloristCommand;
import com.nivel3.view.utils.Command;
import com.nivel3.view.utils.Session;

public class FloristMenuController extends Controller {

	private AddProductController addProductController;
	private AddProductCommand addProductCommand;

	private RemoveProductController removeProductController;
	private RemoveProductCommand removeProductCommand;

	private ChooseStockController chooseStockController;
	private ChooseStockCommand chooseStockCommand;

	private ChooseFloristController chooseFloristController;
	private ChooseFloristCommand chooseFloristCommand;

	private ExitFloristMenuController exitFloristMenuController;
	private ExitFloristMenuCommand exitFloristMenuCommand;

	private Map<Command, Controller> controllers;
	private Menu menu;

	public FloristMenuController(Session session) {
		super(session);
		this.controllers = new HashMap<Command, Controller>();

		this.addProductController = new AddProductController(this.session);
		this.addProductCommand = new AddProductCommand();
		this.removeProductController = new RemoveProductController(this.session);
		this.removeProductCommand = new RemoveProductCommand();

		this.chooseStockController = new ChooseStockController(this.session);
		this.chooseStockCommand = new ChooseStockCommand();

		this.chooseFloristController = new ChooseFloristController(this.session);
		this.chooseFloristCommand = new ChooseFloristCommand("ELEGIR OTRA FLORISTERIA");
		this.exitFloristMenuController = new ExitFloristMenuController(this.session);
		this.exitFloristMenuCommand = new ExitFloristMenuCommand();

		this.controllers.put(addProductCommand, addProductController);
		this.controllers.put(removeProductCommand, removeProductController);
		this.controllers.put(chooseStockCommand, chooseStockController);
		this.controllers.put(chooseFloristCommand, chooseFloristController);
		this.controllers.put(exitFloristMenuCommand, exitFloristMenuController);

		this.menu = new Menu(this.controllers.keySet());
	}

	public void control() {
		this.addProductCommand.setActive(true);
		this.removeProductCommand.setActive(true);
		this.chooseStockCommand.setActive(true);
		this.chooseFloristCommand.setActive(true);
		this.exitFloristMenuCommand.setActive(true);

		this.controllers.get(this.menu.execute()).control();

	}
}
