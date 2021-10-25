package com.nivel3.controller.stockMenu;

import java.util.HashMap;
import java.util.Map;

import com.nivel3.controller.Controller;
import com.nivel3.controller.ExitToFloristMenuController;
import com.nivel3.view.Menu;
import com.nivel3.view.stockMenu.*;
import com.nivel3.view.utils.Command;
import com.nivel3.view.utils.ExitToFloristMenuCommand;
import com.nivel3.view.utils.Session;

public class StockMenuController extends Controller {
	
	private AllProductsController allProductsController;
	private AllProductsCommand allProductsCommand;
	private DecorationStockController decorationStockController;
	private DecorationStockCommand decorationStockCommand;
	private FlowerStockController flowerStockController;
	private FlowerStockCommand flowerStockCommand;
	private TreeStockController treeStockController;
	private TreeStockCommand treeStockCommand;
	private ExitToFloristMenuController exitToFloristMenuController;
	private ExitToFloristMenuCommand exitToFloristMenuCommand;
	
	private Map<Command, Controller> controllers;
	private Menu menu;
	
	public StockMenuController(Session session) {	
		super(session);
		this.controllers = new HashMap<Command, Controller>();
		
		this.allProductsController = new AllProductsController(this.session);
		this.allProductsCommand = new AllProductsCommand();
		this.decorationStockController = new DecorationStockController(this.session);
		this.decorationStockCommand = new DecorationStockCommand();
		this.flowerStockController = new FlowerStockController(this.session);
		this.flowerStockCommand = new FlowerStockCommand();
		this.treeStockController = new TreeStockController(this.session);
		this.treeStockCommand = new TreeStockCommand();
		this.exitToFloristMenuController = new ExitToFloristMenuController(this.session);
		this.exitToFloristMenuCommand = new ExitToFloristMenuCommand();
			
		this.controllers.put(allProductsCommand, allProductsController);
		this.controllers.put(decorationStockCommand, decorationStockController);
		this.controllers.put(flowerStockCommand, flowerStockController);
		this.controllers.put(treeStockCommand, treeStockController);
		this.controllers.put(exitToFloristMenuCommand, exitToFloristMenuController);

		this.menu = new Menu(this.controllers.keySet());
	}	
	public void control() {
		this.allProductsCommand.setActive(true);
		this.decorationStockCommand.setActive(true);
		this.flowerStockCommand.setActive(true);
		this.treeStockCommand.setActive(true);
		this.exitToFloristMenuCommand.setActive(true);

		this.controllers.get(this.menu.execute()).control();

	}
}