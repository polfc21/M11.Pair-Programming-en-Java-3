package com.nivel3.controller.stockMenu;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.ActiveFlorist;
import com.nivel3.model.persistence.FloristRepository;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

import java.util.stream.Collectors;

public class AllProductsController extends Controller {

FloristRepository floristRepository;
	
	public AllProductsController(Session session) {
		super(session);
		this.floristRepository = FloristRepository.instance();
	}
	
	public void control() {
		int id = ActiveFlorist.instance().getId();
		ShowInfoWindow.showInfoStocks("PRODUCTOS", floristRepository.getProducts(id)
				.stream().map(l -> l.toString()).collect(Collectors.toList()), this.getValueStock());
	}
	
	private double getValueStock() {
		int id = ActiveFlorist.instance().getId();
		return this.floristRepository.getProducts(id)
				.stream().map(p -> p.getPrice()).mapToDouble(Double::doubleValue).sum();
		
	}
}

