package model.payment;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChargeTest {

    @Test
    public void shouldNotMarkChargeAsPaidWhenSinglePaymentAndTheAmountPaidIsLessThanTheTotal() {
        Charge charge = new Charge("Customer", 150.00);

        charge.addPayment(new Payment(100.00, PaymentMethod.BOLETO));

        assertFalse(charge.isPaid());
    }

    @Test
    public void shouldMarkChargeAsPaidWhenSinglePaymentAndTheAmountPaidIsGreaterThanTheTotal() {
        Charge charge = new Charge("Customer", 300.00);

        charge.addPayment(new Payment(350.00, PaymentMethod.BOLETO));

        assertTrue(charge.isPaid());
    }

    @Test
    public void shouldMarkChargeAsPaidWhenSinglePaymentAndTheAmountPaidIsEqualTheTotal() {
        Charge charge = new Charge("Customer", 300.00);

        charge.addPayment(new Payment(300.00, PaymentMethod.BOLETO));

        assertTrue(charge.isPaid());
    }
    //
    @Test
    public void shouldNotMarkChargeAsPaidWhenManyPaymentsAndTheAmountPaidIsLessThanTheTotal() {
        Charge charge = new Charge("Customer", 500.00);

        charge.addPayment(new Payment(100.00, PaymentMethod.BOLETO));
        charge.addPayment(new Payment(200.00, PaymentMethod.BOLETO));

        assertFalse(charge.isPaid());
    }

    @Test
    public void shouldMarkChargeAsPaidWhenManyPaymentsAndTheAmountPaidIsGreaterThanTheTotal() {
        Charge charge = new Charge("Customer", 800.00);

        charge.addPayment(new Payment(300.00, PaymentMethod.BOLETO));
        charge.addPayment(new Payment(200.00, PaymentMethod.BOLETO));
        charge.addPayment(new Payment(350.00, PaymentMethod.BOLETO));

        assertTrue(charge.isPaid());
    }

    @Test
    public void shouldMarkChargeAsPaidWhenManyPaymentsAndTheAmountPaidIsEqualTheTotal() {
        Charge charge = new Charge("Customer", 900.00);

        charge.addPayment(new Payment(300.00, PaymentMethod.BOLETO));
        charge.addPayment(new Payment(600.00, PaymentMethod.BOLETO));

        assertTrue(charge.isPaid());
    }
}