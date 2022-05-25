package service;

import lombok.Getter;
import model.Cart;
import model.Product;

@Getter
public class MajorAndMinor {

    private Product minor;
    private Product major;

    public void findMajorAndMinor(Cart cart) {
        cart.getProducts().forEach(
                p -> {
                    if (minor == null || p.getPrice() < minor.getPrice()){
                        minor = p;
                    }
                    if (major == null || p.getPrice() > major.getPrice()){
                        major = p;
                    }
                }
        );

    }

}
