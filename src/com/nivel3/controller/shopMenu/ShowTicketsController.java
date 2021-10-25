package com.nivel3.controller.shopMenu;

import java.util.stream.Collectors;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.ActiveFlorist;
import com.nivel3.model.persistence.FloristRepository;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

public class ShowTicketsController extends Controller {
	
	FloristRepository floristRepository;
	
    public ShowTicketsController(Session session) {
        super(session);
        this.floristRepository = FloristRepository.instance();
    }

    @Override
    public void control() {
    	int id = ActiveFlorist.instance().getId();
    	
    	ShowInfoWindow.showInfo(floristRepository.getTickets(id)
    			.stream().map(t -> t.toString()).collect(Collectors.toList()));
    }
}
