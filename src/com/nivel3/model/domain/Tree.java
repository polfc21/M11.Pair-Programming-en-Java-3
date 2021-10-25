package com.nivel3.model.domain;

public class Tree extends Product{

    private double height;

    public Tree(String name, double price, double height) {
        super(name, price);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
 // PRUEBAS: para crear �rboles al inicio del repository
   	public static Tree createTestTree(String name, double price, double height){
   		Tree testTree = new Tree(name, price, height);
   		return testTree;
   	}
   	
    @Override
    public String toString() {
        return "ARBOL\tId=" + super.getId() +"\tNombre: " +super.getName()+ "\tAltura: " + height + "m\tPrecio: " + super.getPrice() + "€";
    }
}
