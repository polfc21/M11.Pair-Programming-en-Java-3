package com.nivel3.model.domain;

public class Decoration extends Product{

    private String material;

    public Decoration(String name, double price, String material) {
        super(name, price);
        this.material = material.toUpperCase();
    }
    
 // PRUEBAS: para crear decos al inicio del repository
 	public static Decoration createTestDeco(String name, double price, String material){
 		Decoration testDecoration = new Decoration(name, price, material);
 		return testDecoration;
 	}

    @Override
    public String toString() {
        return "DECO\tId=" + super.getId() + "\tNombre: "+ super.getName() + "\tMat: "+ material + "\tPrecio: " + super.getPrice() + "€";
    }
}
