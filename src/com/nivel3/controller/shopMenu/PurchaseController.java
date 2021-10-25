package com.nivel3.controller.shopMenu;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.ActiveFlorist;
import com.nivel3.view.utils.Session;

public class PurchaseController extends Controller {
    public PurchaseController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        this.session.purchaseMenu();
    }

    public boolean isProductListEmpty(){
        return ActiveFlorist.instance().getProducts().size() == 0;
    }
}
