package service.payment;

import model.payment.Boleto;
import model.payment.Charge;
import model.payment.Payment;
import model.payment.PaymentMethod;

import java.util.List;

public class BoletoProcessor {
    public void process(List<Boleto> boletos, Charge charge) {
        for (Boleto b : boletos) {
            charge.addPayment(new Payment(b.getValue(), PaymentMethod.BOLETO));
        }
    }
}
