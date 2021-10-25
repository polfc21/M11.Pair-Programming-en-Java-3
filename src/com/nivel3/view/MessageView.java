package com.nivel3.view;

public enum MessageView {

    CREATE_FLORIST("Introduce el nombre de la floristería","CREAR FLORISTERIA"),
    CHOOSE_FLORIST("Introduce el ID de la floristería","ELEGIR FLORISTERIA"),
    NAME_PRODUCT("Introduce el nombre del producto", "CREAR PRODUCTO"),
    PRICE_PRODUCT("Introduce el precio del producto", "CREAR PRODUCTO"),
    HEIGHT_TREE("Introduce la altura del árbol", "CREAR ARBOL"),
    COLOR_FLOWER("Introduce el color de la flor", "CREAR FLOR"),
    MATERIAL_DECORATION("Introduce el material de la decoración (MADERA o PLASTICO)", "CREAR DECORACION"),
	CHOOSE_PRODUCT("Introduce el ID del producto", "SELECCIONAR PRODUCTO");
	
    private String message;
    private String title;

    MessageView(String message, String title) {
        this.message = message;
        this.title = title;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTitle() {
        return this.title;
    }
}
