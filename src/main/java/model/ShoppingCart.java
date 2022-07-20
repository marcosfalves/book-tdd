package model;

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
}