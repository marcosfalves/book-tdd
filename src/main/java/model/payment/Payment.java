package model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Payment {
    private double value;
    private PaymentMethod paymentMethod;
}
