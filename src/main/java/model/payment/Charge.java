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

    public void addPayment(Payment payment) {
        this.payments.add(payment);

        double totalPaid = 0.0;
        for (Payment p: payments){
            totalPaid += p.getValue();
        }

        if (totalPaid >= this.value){
            this.paid = true;
        }
    }
}
