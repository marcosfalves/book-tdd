package service.invoice;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import model.invoice.Invoice;
import model.invoice.Order;
import org.junit.Test;

public class InvoiceGeneratorTest {

    @Test
    public void shouldGenerateInvoiceWithDiscountedTaxValue() {
        InvoiceDao dao = mock(InvoiceDao.class);
        SAP sap = mock(SAP.class);

        InvoiceGenerator generator = new InvoiceGenerator(dao, sap);
        Order order = new Order("Marcos", 1000, 1);

        Invoice invoice = generator.generates(order);

        assertEquals(1000 * 0.94, invoice.getValue(), 0.0001);
    }

    @Test
    public void shouldPersistInvoice(){
        //mock create
        InvoiceDao dao = mock(InvoiceDao.class);
        SAP sap = mock(SAP.class);

        InvoiceGenerator generator = new InvoiceGenerator(dao, sap);
        Order order = new Order("Marcos", 1000, 1);

        Invoice invoice = generator.generates(order);

        //verifying that the method was invoked
        verify(dao).persist(invoice);
    }

    @Test
    public void shouldSendGeneratedInvoiceToSAP(){
        InvoiceDao dao = mock(InvoiceDao.class);
        SAP sap = mock(SAP.class);

        InvoiceGenerator generator = new InvoiceGenerator(dao, sap);
        Order order = new Order("Marcos", 1000, 1);

        Invoice invoice = generator.generates(order);

        verify(sap).send(invoice);
    }
}
