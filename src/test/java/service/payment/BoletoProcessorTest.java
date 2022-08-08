package service.payment;

import static org.junit.Assert.*;

import model.payment.Boleto;
import model.payment.Charge;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BoletoProcessorTest  {

    private BoletoProcessor boletoProcessor;

    @Before
    public void setUp() throws Exception {
        boletoProcessor = new BoletoProcessor();
    }

    @Test
    public void shouldProcessPaymentBySingleBoleto(){
        Charge charge = new Charge("Customer", 150.00);

        Boleto b1 = new Boleto(150.00);

        List<Boleto> boletos = List.of(b1);

        boletoProcessor.process(boletos, charge);

        assertEquals(1, charge.getPayments().size());
        assertEquals(150.00, charge.getPayments().get(0).getValue(), 0.00001);
    }

    @Test
    public void shouldProcessPaymentByManyBoletos(){
        Charge charge = new Charge("Customer", 300.00);

        Boleto b1 = new Boleto(100.00);
        Boleto b2 = new Boleto(200.00);

        List<Boleto> boletos = List.of(b1, b2);

        boletoProcessor.process(boletos, charge);

        assertEquals(2, charge.getPayments().size());
        assertEquals(100.00, charge.getPayments().get(0).getValue(), 0.00001);
        assertEquals(200.00, charge.getPayments().get(1).getValue(), 0.00001);
    }

    @Test
    public void shouldMarkChargeHowToPaidWhenSingleBoletoAllPaid(){
        Charge charge = new Charge("Customer", 150.00);
        Boleto b1 = new Boleto(150.00);
        List<Boleto> boletos = List.of(b1);

        boletoProcessor.process(boletos, charge);

        assertTrue(charge.isPaid());
    }
}