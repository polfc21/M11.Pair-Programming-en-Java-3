package com.nivel3.controller.purchaseMenu;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.ActiveTicket;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

public class CancelPurchaseController extends Controller {
    public CancelPurchaseController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        ActiveTicket.setNull();
        ShowInfoWindow.showInfo("COMPRA CANCELADA");
    }

    public boolean isActiveTicket(){
        return ActiveTicket.isActiveTicket();
    }
}
