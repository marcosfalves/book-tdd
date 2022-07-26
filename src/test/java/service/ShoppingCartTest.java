package service;

import static org.junit.Assert.*;

import model.Item;
import model.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void init(){
        cart = new ShoppingCart();
    }

    @Test
    public void shouldReturnZeroWhenShoppingCartIsEmpty() {
        assertEquals(0.0, cart.highestTotalValue(), 0.0001);
    }

    @Test
    public void shouldReturnItemAmountWhenShoppingCartHasOneElement(){
        cart.add(new Item("Refrigerator", 1, 900.00));

        assertEquals(900.00, cart.highestTotalValue(), 0.0001);
    }

    @Test
    public void shouldReturnMajorAmountWhenShoppingCartHasManyElements(){
        cart.add(new Item("Refrigerator", 1, 900.00));
        cart.add(new Item("Stove", 1, 1500.00));
        cart.add(new Item("Washer", 1, 750.00));

        assertEquals(1500.00, cart.highestTotalValue(), 0.0001);
    }

}