package com.nivel3.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Florist {
	
	private static int countId=1;
	private int id;
    private String name;
    private List<Product> products;
    private List<Ticket> tickets;

    public Florist(String name){
    	this.id = countId;
    	countId++;
        this.name = name;
        this.products = new ArrayList<Product>();
        this.tickets = new ArrayList<Ticket>();
    }
    
    public int getId() {
    	return id;
    }
    

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public List<Ticket> getTickets() { return this.tickets; }

    public Product getProduct(int id) {
    	Product product = null;
    	for(Product p : products) {
    		if(p.getId()==id) {
    			product = p;
    		}
    	}
    	return product;
    }
    
    public void add(Product product) {
        this.products.add(product);
    }

    public void add(Ticket ticket) {
        this.tickets.add(ticket);
    }
 // PRUEBAS: para a�adir registros al inicio del repository
 	public static Florist createTestFlorist(String name) {
 		Florist testFlorist = new Florist(name);
 		return testFlorist;
 	}
   

	@Override
	public String toString() {
		return "ID=" + id + "\tNombre: " + name;
	}

   
}
