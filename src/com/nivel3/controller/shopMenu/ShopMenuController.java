package com.nivel3.controller.shopMenu;

import com.nivel3.controller.Controller;
import com.nivel3.controller.mainMenu.ChooseFloristController;
import com.nivel3.view.Menu;
import com.nivel3.view.mainMenu.ChooseFloristCommand;
import com.nivel3.view.shopMenu.ExitShopCommand;
import com.nivel3.view.shopMenu.PurchaseCommand;
import com.nivel3.view.shopMenu.ShowGainsCommand;
import com.nivel3.view.shopMenu.ShowTicketsCommand;
import com.nivel3.view.utils.Command;
import com.nivel3.view.utils.Session;

import java.util.HashMap;
import java.util.Map;

public class ShopMenuController extends Controller {

    private Map<Command, Controller> controllers;
    private PurchaseController purchaseController;
    private PurchaseCommand purchaseCommand;
    private ShowGainsController showGainsController;
    private ShowGainsCommand showGainsCommand;
    private ShowTicketsController showTicketsController;
    private ShowTicketsCommand showTicketsCommand;
    private ChooseFloristController chooseFloristController;
    private ChooseFloristCommand chooseFloristCommand;
    private ExitShopController exitShopController;
    private ExitShopCommand exitShopCommand;
    private Menu menu;

    public ShopMenuController(Session session) {
        super(session);
        this.controllers = new HashMap<Command, Controller>();
        this.purchaseController = new PurchaseController(this.session);
        this.purchaseCommand = new PurchaseCommand();
        this.showGainsController = new ShowGainsController(this.session);
        this.showGainsCommand = new ShowGainsCommand();
        this.showTicketsController = new ShowTicketsController(this.session);
        this.showTicketsCommand = new ShowTicketsCommand();
        this.chooseFloristController = new ChooseFloristController(this.session);
        this.chooseFloristCommand = new ChooseFloristCommand("SELECCIONAR FLORISTERIA");
        this.exitShopController = new ExitShopController(this.session);
        this.exitShopCommand = new ExitShopCommand();

        this.controllers.put(this.purchaseCommand, this.purchaseController);
        this.controllers.put(this.showGainsCommand, this.showGainsController);
        this.controllers.put(this.showTicketsCommand, this.showTicketsController);
        this.controllers.put(this.chooseFloristCommand, this.chooseFloristController);
        this.controllers.put(this.exitShopCommand, this.exitShopController);

        this.menu = new Menu(this.controllers.keySet());
    }

    public void control() {
        this.purchaseCommand.setActive(!this.purchaseController.isProductListEmpty());
        this.showGainsCommand.setActive(true);
        this.showTicketsCommand.setActive(true);
        this.chooseFloristCommand.setActive(true);
        this.exitShopCommand.setActive(true);
        this.controllers.get(this.menu.execute()).control();

    }

}
