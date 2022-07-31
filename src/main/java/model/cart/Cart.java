package model.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.util.List;

@Data
@With
@Builder
@AllArgsConstructor
public class Cart {
    private final List<Product> products;
}