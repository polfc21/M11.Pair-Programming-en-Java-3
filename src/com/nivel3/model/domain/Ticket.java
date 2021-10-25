package com.nivel3.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket {

	private int id;
	private LocalDate date;
	private List<Product> products;
	
	public Ticket(int sizeTicketsList) {
		this.id = sizeTicketsList + 1;
		this.date = LocalDate.now();
		this.products = new ArrayList<Product>();
	}

	public void add(Product product){
		this.products.add(product);
	}

	public List<Product> getProducts(){
		return this.products;
	}
	
	public double getAmount() {
		return this.products.stream().map(p -> p.getPrice()).mapToDouble(Double::doubleValue).sum();
	}

	public String toString() {
		String productsStr =  products.stream().map(p -> p.toString() + "\n").collect(Collectors.toList()).toString();
		return "ID=" + id + "\tFECHA: " + date.toString() + "\n" + productsStr;
	}

}
