package service.cart;

import static org.junit.Assert.*;

import model.cart.Cart;
import model.cart.Product;
import org.junit.Test;
import service.cart.MajorAndMinor;

import java.util.ArrayList;
import java.util.List;

public class MajorAndMinorTest {

    @Test
    public void descendingOrder(){
        List<Product> products = new ArrayList<>();
        products.add(Product.builder().id("1").name("Geladeira").price(450.00).build());
        products.add(new Product("2", "Liquidificador", 250.00));
        products.add(new Product("3", "Jogo de pratos", 70.00));

        Cart cart = new Cart(products);

        MajorAndMinor algoritm = new MajorAndMinor();
        algoritm.findMajorAndMinor(cart);

        assertEquals("Jogo de pratos", algoritm.getMinor().getName());
        assertEquals("Geladeira", algoritm.getMajor().getName());
    }

    @Test
    public void onlyOneProduct(){
        List<Product> products = new ArrayList<>();
        products.add(Product.builder().id("1").name("Geladeira").price(450.00).build());

        Cart cart = new Cart(products);

        MajorAndMinor algoritm = new MajorAndMinor();
        algoritm.findMajorAndMinor(cart);

        assertEquals("Geladeira", algoritm.getMinor().getName());
        assertEquals("Geladeira", algoritm.getMajor().getName());
    }

}