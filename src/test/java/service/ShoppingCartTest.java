package service;

import builders.ShoppingCartBuilder;
import model.Item;
import model.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void init(){
        cart = new ShoppingCart();
    }

    @Test
    public void shouldAddItems(){
        assertEquals(0, cart.getItems().size());

        Item item = new Item("Refrigerator", 1, 900.00);
        cart.add(item);

        assertEquals(1, cart.getItems().size());
        assertEquals(item, cart.getItems().get(0));
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
        cart = new ShoppingCartBuilder()
                .withItems(900.00, 1500.00, 750.00)
                .build();

        /*cart.add(new Item("Refrigerator", 1, 900.00));
        cart.add(new Item("Stove", 1, 1500.00));
        cart.add(new Item("Washer", 1, 750.00));*/

        assertEquals(1500.00, cart.highestTotalValue(), 0.0001);
    }

    @Test
    public void testingLists(){
        cart = new ShoppingCartBuilder()
                .withItems(100.00, 500.00)
                .build();

        assertEquals(2, cart.getItems().size());

        assertEquals(100.00, cart.getItems().get(0).getUnitaryValue(), 0.0001);
        assertEquals(500.00, cart.getItems().get(1).getUnitaryValue(), 0.0001);
    }
}