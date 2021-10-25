package com.nivel3.controller.shopMenu;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.ActiveFlorist;
import com.nivel3.model.persistence.FloristRepository;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

public class ShowGainsController extends Controller {
	
	FloristRepository floristRepository;
	
    public ShowGainsController(Session session) {
        super(session);
        this.floristRepository = FloristRepository.instance();
    }

    @Override
    public void control() {
    	String name = ActiveFlorist.instance().getName();
    	ShowInfoWindow.showInfo("El total de ganancias de la floristería " + name.toUpperCase() +" es de: " + this.getValueTickets() +"€");
    }
    
    private double getValueTickets() {
    	int id = ActiveFlorist.instance().getId();
    	return this.floristRepository.getTickets(id).stream().map(t -> t.getAmount()).mapToDouble(Double::doubleValue).sum();
    }
}
