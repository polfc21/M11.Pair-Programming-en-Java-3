package com.nivel3.controller.purchaseMenu;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.ActiveFlorist;
import com.nivel3.model.domain.ActiveTicket;
import com.nivel3.model.persistence.FloristRepository;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

public class PayPurchaseController extends Controller {

    private FloristRepository floristRepository;

    public PayPurchaseController(Session session) {
        super(session);
        this.floristRepository = FloristRepository.instance();
    }

    @Override
    public void control() {
        this.floristRepository.add(ActiveTicket.instance(), ActiveFlorist.instance().getId());
        ShowInfoWindow.showInfo("COMPRA REALIZADA");
        ActiveTicket.instance().getProducts()
                .stream().forEach(x -> this.floristRepository.remove(x,ActiveFlorist.instance().getId()));
        ActiveTicket.setNull();
    }

    public boolean isActiveTicket(){
        return ActiveTicket.isActiveTicket();
    }
}
