package com.nivel3.controller.mainMenu;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.ActiveFlorist;
import com.nivel3.model.persistence.FloristRepository;
import com.nivel3.view.utils.Session;

public class ShopController extends Controller {

    FloristRepository floristRepository;
    public ShopController(Session session){
        super(session);
        this.floristRepository = FloristRepository.instance();
    }

    @Override
    public void control() {
        this.session.shopMenu();
    }

    public boolean isFloristListEmpty() {
        return this.floristRepository.getSizeFlorist()==0;
    }

    public boolean isActiveFlorist() {
        return ActiveFlorist.isActiveFlorist();
    }
}
