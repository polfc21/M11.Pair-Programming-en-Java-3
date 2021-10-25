package com.nivel3.controller.purchaseMenu;

import com.nivel3.controller.Controller;
import com.nivel3.view.utils.Session;

public class ExitPurchaseController extends Controller {
    public ExitPurchaseController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        this.session.shopMenu();
    }
}
