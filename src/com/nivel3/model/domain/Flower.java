package com.nivel3.model.domain;

public class Flower extends Product{

    private String color;

    public Flower(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
 // PRUEBAS: para crear flores al inicio del repository
  	public static Flower createTestFlower(String name, double price, String color){
  		Flower testFlower = new Flower(name, price, color);
  		return testFlower;
  	}
  	
    @Override
    public String toString() {
        return "FLOR\tId=" + super.getId() + "\tNombre: " + super.getName() + "\tColor: " + color + "\tPrecio: " + super.getPrice() + "€";
    }
}
