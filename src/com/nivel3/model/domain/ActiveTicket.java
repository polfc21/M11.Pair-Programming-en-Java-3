package com.nivel3.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActiveTicket {
    private static Ticket activeTicket;
    private static List<Product> stockCloned;

    public static Ticket instance() {
        return activeTicket;
    }

    private ActiveTicket() {
    }

    public static boolean isActiveTicket() {
        return activeTicket != null;
    }

    public static void setNull(){
        activeTicket = null;
        stockCloned = null;
    }

    public static List<Product> getStockCloned(){
        return stockCloned;
    }

    public static void setActive(Ticket ticket) {
        activeTicket = ticket;
    }

    public static void cloneStock(List<Product> products){
        stockCloned = products.stream().collect(Collectors.toList());
    }
}
