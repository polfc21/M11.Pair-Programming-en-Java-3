package com.nivel3.controller.shopMenu;

import com.nivel3.controller.Controller;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

public class ExitShopController extends Controller {

    public ExitShopController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        ShowInfoWindow.showInfo("VOLVIENDO AL MENU PRINCIPAL...");
        this.session.mainMenu();
    }
}
