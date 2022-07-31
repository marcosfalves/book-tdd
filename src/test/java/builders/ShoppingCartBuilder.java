package builders;

import model.shoppingcart.Item;
import model.shoppingcart.ShoppingCart;

public class ShoppingCartBuilder {

    public ShoppingCart cart;

    public ShoppingCartBuilder() {
        this.cart = new ShoppingCart();
    }

    public ShoppingCartBuilder withItems(double... values) {
        for (double value : values){
            cart.add(new Item("Item", 1, value));
        }
        return this;
    }

    public ShoppingCart build() {
        return cart;
    }
}
