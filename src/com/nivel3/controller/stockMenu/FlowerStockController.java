package com.nivel3.controller.stockMenu;

import java.util.stream.Collectors;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.ActiveFlorist;
import com.nivel3.model.domain.Flower;
import com.nivel3.model.persistence.FloristRepository;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

public class FlowerStockController extends Controller {
	FloristRepository floristRepository;

	public FlowerStockController(Session session) {
		super(session);
		this.floristRepository = FloristRepository.instance();
	}

	public void control() {
		int id = ActiveFlorist.instance().getId();
		ShowInfoWindow.showInfoStocks("FLORES", floristRepository.getProducts(id)
				.stream().filter(s -> s instanceof Flower).map(l -> l.toString()).collect(Collectors.toList()),
				this.getValueStock());
	}
	
	private double getValueStock() {
		int id = ActiveFlorist.instance().getId();
		return this.floristRepository.getProducts(id)
				.stream().filter(f -> f instanceof Flower).map(f -> f.getPrice()).mapToDouble(Double::doubleValue).sum();
		
	}
}