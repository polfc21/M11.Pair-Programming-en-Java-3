package com.nivel3.controller.removeProdMenu;

import java.util.List;
import java.util.stream.Collectors;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.ActiveFlorist;
import com.nivel3.model.domain.Decoration;
import com.nivel3.model.domain.Product;
import com.nivel3.model.persistence.FloristRepository;
import com.nivel3.view.MessageView;
import com.nivel3.view.ReadInfoWindow;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

public class RemoveDecorationController extends Controller{

	FloristRepository floristRepository;
	
	public RemoveDecorationController(Session session) {
		super(session);
		this.floristRepository = FloristRepository.instance();
	}
	
	public void control() {
		int activeFloristId = ActiveFlorist.instance().getId();
		List<String> decorationStock = floristRepository.getProducts(activeFloristId).stream()
				.filter(s -> s instanceof Decoration).map(l -> l.toString()).collect(Collectors.toList());
		ShowInfoWindow.showInfo(decorationStock);
		if (decorationStock.isEmpty()) {
			ShowInfoWindow.showInfo("NO HAY PRODUCTOS PARA RETIRAR DE ESTE STOCK");
		} else {
			Product product = floristRepository.getProductById(activeFloristId, this.getProdId());
			if (product instanceof Decoration) {
				this.floristRepository.remove(product, activeFloristId);
				ShowInfoWindow.showInfo("DECORACION ELIMINADA");
			}
		}
	}
	
	private int getProdId() {
		return ReadInfoWindow.readIdProduct(MessageView.CHOOSE_PRODUCT, this.getIdList());
	}
	
	private List<Integer> getIdList() {
		int activeFloristId = ActiveFlorist.instance().getId();
		return this.floristRepository.getProducts(activeFloristId).stream().filter(s-> s instanceof Decoration).map(s -> s.getId()).collect(Collectors.toList());
	}

}

