package com.nivel3.controller.purchaseMenu;

import com.nivel3.controller.Controller;
import com.nivel3.model.domain.*;
import com.nivel3.model.persistence.FloristRepository;
import com.nivel3.view.MessageView;
import com.nivel3.view.ReadInfoWindow;
import com.nivel3.view.ShowInfoWindow;
import com.nivel3.view.utils.Session;

import java.util.List;
import java.util.stream.Collectors;

public class AddProductController extends Controller {

    private FloristRepository floristRepository;

    public AddProductController(Session session) {
        super(session);
        this.floristRepository = FloristRepository.instance();

    }

    @Override
    public void control() {
        if (!ActiveTicket.isActiveTicket()){
            this.createActiveTicket();
        }
        this.showStockCloned();
        if (ActiveTicket.getStockCloned().size() == 0){
            ShowInfoWindow.showInfo("STOCK VACIO");
        }else{
            Product product = floristRepository.getProductById(ActiveFlorist.instance().getId(), this.getProdId());
            if (product != null) {
                ActiveTicket.instance().add(product);
                ActiveTicket.getStockCloned().remove(product);
                ShowInfoWindow.showInfo("PRODUCTO AÑADIDO");
            }
        }
    }

    private int getProdId() {
        return ReadInfoWindow.readIdProduct(MessageView.CHOOSE_PRODUCT, this.getIdList());
    }

    private List<Integer> getIdList() {
        return ActiveTicket.getStockCloned().stream().map(s -> s.getId()).collect(Collectors.toList());
    }

    private void showStockCloned() {
        List<String> stockCloned = ActiveTicket.getStockCloned().stream()
                .map(l -> l.toString()).collect(Collectors.toList());
        ShowInfoWindow.showInfo(stockCloned);
    }

    private void createActiveTicket(){
        int idTicket = ActiveFlorist.instance().getTickets().size() + 1;
        ActiveTicket.setActive(new Ticket(idTicket));
        int idActiveFlorist = ActiveFlorist.instance().getId();
        ActiveTicket.cloneStock(this.floristRepository.getProducts(idActiveFlorist));
    }

    public boolean isProductListEmpty(){
        return ActiveFlorist.instance().getProducts().isEmpty();
    }

}
