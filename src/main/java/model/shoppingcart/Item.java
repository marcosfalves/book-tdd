package model.shoppingcart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@With
@Builder
@AllArgsConstructor
public class Item {
    private final String description;
    private final Integer quantity;
    private final Double unitaryValue;

    public Double getTotalValue(){
        return this.unitaryValue * this.quantity;
    }
}