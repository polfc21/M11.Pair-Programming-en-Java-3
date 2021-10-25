package com.nivel3.controller.purchaseMenu;

import com.nivel3.controller.Controller;
import com.nivel3.controller.mainMenu.ChooseFloristController;
import com.nivel3.controller.shopMenu.ExitShopController;
import com.nivel3.controller.shopMenu.PurchaseController;
import com.nivel3.controller.shopMenu.ShowGainsController;
import com.nivel3.controller.shopMenu.ShowTicketsController;
import com.nivel3.model.domain.ActiveTicket;
import com.nivel3.view.Menu;
import com.nivel3.view.mainMenu.ChooseFloristCommand;
import com.nivel3.view.purchaseMenu.AddProductCommand;
import com.nivel3.view.purchaseMenu.CancelPurchaseCommand;
import com.nivel3.view.purchaseMenu.ExitPurchaseCommand;
import com.nivel3.view.purchaseMenu.PayPurchaseCommand;
import com.nivel3.view.shopMenu.ExitShopCommand;
import com.nivel3.view.shopMenu.PurchaseCommand;
import com.nivel3.view.shopMenu.ShowGainsCommand;
import com.nivel3.view.shopMenu.ShowTicketsCommand;
import com.nivel3.view.utils.Command;
import com.nivel3.view.utils.Session;

import java.util.HashMap;
import java.util.Map;

public class PurchaseMenuController extends Controller {

    private Map<Command, Controller> controllers;
    private AddProductController addProductController;
    private AddProductCommand addProductCommand;
    private CancelPurchaseController cancelPurchaseController;
    private CancelPurchaseCommand cancelPurchaseCommand;
    private PayPurchaseController payPurchaseController;
    private PayPurchaseCommand payPurchaseCommand;
    private ExitPurchaseController exitPurchaseController;
    private ExitPurchaseCommand exitPurchaseCommand;
    private Menu menu;

    public PurchaseMenuController(Session session) {
        super(session);
        this.controllers = new HashMap<Command, Controller>();
        this.addProductController = new AddProductController(this.session);
        this.addProductCommand = new AddProductCommand();
        this.cancelPurchaseController = new CancelPurchaseController(this.session);
        this.cancelPurchaseCommand = new CancelPurchaseCommand();
        this.payPurchaseController = new PayPurchaseController(this.session);
        this.payPurchaseCommand = new PayPurchaseCommand();
        this.exitPurchaseController = new ExitPurchaseController(this.session);
        this.exitPurchaseCommand = new ExitPurchaseCommand();

        this.controllers.put(this.addProductCommand, this.addProductController);
        this.controllers.put(this.cancelPurchaseCommand, this.cancelPurchaseController);
        this.controllers.put(this.payPurchaseCommand, this.payPurchaseController);
        this.controllers.put(this.exitPurchaseCommand, this.exitPurchaseController);

        this.menu = new Menu(this.controllers.keySet());
    }

    @Override
    public void control() {
        this.addProductCommand.setActive(!this.addProductController.isProductListEmpty());
        this.cancelPurchaseCommand.setActive(this.cancelPurchaseController.isActiveTicket());
        this.payPurchaseCommand.setActive(this.payPurchaseController.isActiveTicket());
        this.exitPurchaseCommand.setActive(true);
        this.controllers.get(this.menu.execute()).control();
    }
}
