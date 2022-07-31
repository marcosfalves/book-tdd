package model.shoppingcart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart(){
        this.items = new ArrayList<>();
    }

    public void add(Item item){
        this.items.add(item);
    }

    public List<Item> getItems(){
        return Collections.unmodifiableList(items);
    }

    public double highestTotalValue() {
        if (getItems().isEmpty()) return 0;
        double major = getItems().get(0).getTotalValue();

        for (Item item : getItems()) {
            if (major < item.getTotalValue()){
                major = item.getTotalValue();
            }
        }
        return major;
    }
}