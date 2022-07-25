package service;

import model.Item;
import model.ShoppingCart;

public class MajorAmount {

    public double find(ShoppingCart cart) {
        if (cart.getItems().isEmpty()) return 0;
        double major = cart.getItems().get(0).getTotalValue();

        for (Item item : cart.getItems()) {
            if (major < item.getTotalValue()){
                major = item.getTotalValue();
            }
        }
        return major;
    }

}
