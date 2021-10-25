package com.nivel3.controller.stockMenu;

import java.util.stream.Collectors;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.ActiveFlorist;
import com.nivel3.model.domain.Decoration;
import com.nivel3.model.persistence.FloristRepository;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

public class DecorationStockController extends Controller {

	FloristRepository floristRepository;

	public DecorationStockController(Session session) {
		super(session);
		this.floristRepository = FloristRepository.instance();
	}

	public void control() {
		int id = ActiveFlorist.instance().getId();
		ShowInfoWindow.showInfoStocks("DECORACIONES", floristRepository.getProducts(id)
				.stream().filter(s -> s instanceof Decoration).map(l -> l.toString()).collect(Collectors.toList()), this.getValueStock());
	}
	private double getValueStock() {
		int id = ActiveFlorist.instance().getId();
		return this.floristRepository.getProducts(id)
				.stream().filter(d -> d instanceof Decoration).map(d -> d.getPrice()).mapToDouble(Double::doubleValue).sum();
		
	}
}

