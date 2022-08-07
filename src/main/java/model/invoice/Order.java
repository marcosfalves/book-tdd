package model.invoice;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Order {
    private String customer;
    private double totalValue;
    private int quantityItems;
}
