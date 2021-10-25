package com.nivel3.model.persistence;

import java.util.ArrayList;
import java.util.List;

import com.nivel3.model.domain.*;

public class FloristRepository {

    private static FloristRepository floristRepository;
    private static List<Florist> floristList;

    private FloristRepository(){
        floristList = new ArrayList<Florist>();
    }

    public static FloristRepository instance() {
        if (floristList == null) {
            floristRepository = new FloristRepository();
        }
        return floristRepository;
    }
    
    public void add(Florist florist) {
    	floristList.add(florist);
    }
    
    public void add(Product product, int id) {
    	this.getFloristById(id).add(product);
    }

    public void add(Ticket ticket, int id) { this.getFloristById(id).add(ticket);}
    
    public void remove(Product product, int id) {
    	this.getFloristById(id).getProducts().remove(product);
    }
    
    public Product getProductById(int activeFloristId, int productId) {
    	return this.getFloristById(activeFloristId).getProduct(productId);
    }
    public List<Product> getProducts(int activeId){
    	return this.getFloristById(activeId).getProducts();
    }
    
    public List<Ticket> getTickets(int activeId){
    	return this.getFloristById(activeId).getTickets();
    }
    
    public int getSizeFlorist() {
    	return floristList.size();
    }
    
    public List<Florist> getFlorisList(){
    	return floristList;
    }
    
    public Florist getFloristById(int id) {
    	return floristList.get(id-1);
    }
    
 // PRUEBAS: para a�adir autom�ticamente algunos registros
 	public void testInitRep(int i) {
 		Florist florist = Florist.createTestFlorist("test" + i);
 		for(int j=1; j<=i+2; j++) {
 			florist.add(Flower.createTestFlower("test" + j, j, "color"+j));
 			florist.add(Tree.createTestTree("test"+j, j, 2.5+j));
 			florist.add(Decoration.createTestDeco("test" + j, j, "madera"));
 		}
 		floristList.add(florist);
 		
 	}
}
