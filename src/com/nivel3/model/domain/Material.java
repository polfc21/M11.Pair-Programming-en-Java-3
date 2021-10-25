package com.nivel3.model.domain;

public enum Material {
    WOOD("MADERA"),
    PLASTIC("PLASTICO");

    private String type;

    Material(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static boolean exists(String inputMaterial){
        Material[] materials = Material.values();
        for (Material material : materials){
            if (material.getType().equalsIgnoreCase(inputMaterial)){
                return true;
            }
        }
        return false;
    }
}
