package com.nivel3.controller.mainMenu;

import java.util.HashMap;
import java.util.Map;

import com.nivel3.controller.Controller;
import com.nivel3.model.persistence.FloristRepository;
import com.nivel3.view.Menu;
import com.nivel3.view.mainMenu.*;
import com.nivel3.view.utils.Command;
import com.nivel3.view.utils.Session;

public class MainMenuController extends Controller{
	
	private Map<Command, Controller> controllers;
	private CreateFloristController createFloristController;
	private CreateFloristCommand createFloristCommand;
	private ChooseFloristController chooseFloristController;
	private ChooseFloristCommand chooseFloristCommand;
	private ShopController shopController;
	private ShopCommand shopCommand;
	private ExitMenuController exitMenuController;
	private ExitMenuCommand exitMenuCommand;
	private Menu menu;
	
	public MainMenuController(Session session) {
		super(session);
		this.controllers = new HashMap<Command, Controller>();
		this.createFloristController = new CreateFloristController(this.session);
		this.createFloristCommand = new CreateFloristCommand();
		this.chooseFloristController = new ChooseFloristController(this.session);
		this.chooseFloristCommand = new ChooseFloristCommand("SELECCIONAR FLORISTERIA");
		this.shopController = new ShopController(this.session);
		this.shopCommand = new ShopCommand();
		this.exitMenuController = new ExitMenuController(this.session);
		this.exitMenuCommand = new ExitMenuCommand();

		this.controllers.put(this.createFloristCommand, this.createFloristController);
		this.controllers.put(this.chooseFloristCommand, this.chooseFloristController);
		this.controllers.put(this.shopCommand,this.shopController);
		this.controllers.put(this.exitMenuCommand, this.exitMenuController);
		
		this.menu = new Menu(this.controllers.keySet());
		addTestUsers();
	}

	public void control() {

		this.createFloristCommand.setActive(true);
		this.chooseFloristCommand.setActive(!this.chooseFloristController.isFloristListEmpty());
		this.shopCommand.setActive(!this.shopController.isFloristListEmpty() && this.shopController.isActiveFlorist());
		this.exitMenuCommand.setActive(true);
		this.controllers.get(this.menu.execute()).control();
		
	}
	
//PRUEBAS: a�adir floristerias al repositorio
	public static void addTestUsers() {
		FloristRepository.instance().testInitRep(1);
		FloristRepository.instance().testInitRep(2);
		FloristRepository.instance().testInitRep(3);

/*TEST*/System.out.println(FloristRepository.instance().getFlorisList().toString());	
		}
	
}
