package model.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class Charge {
    private String customerName;
    private double value;
    private boolean paid;
    private List<Payment> payments;

    public Charge(String customerName, double value) {
        this.customerName = customerName;
        this.value = value;
        this.payments = new ArrayList<>();
    }
}
