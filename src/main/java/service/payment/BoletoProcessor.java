package service.payment;

import model.payment.Boleto;
import model.payment.Charge;
import model.payment.Payment;
import model.payment.PaymentMethod;

import java.util.List;

public class BoletoProcessor {
    public void process(List<Boleto> boletos, Charge charge) {
        double totalPaid = 0.0;

        for (Boleto b : boletos) {
            charge.getPayments().add(new Payment(b.getValue(), PaymentMethod.BOLETO));
            totalPaid += b.getValue();
        }

        if (totalPaid >= charge.getValue()){
            charge.setPaid(true);
        }
    }
}
