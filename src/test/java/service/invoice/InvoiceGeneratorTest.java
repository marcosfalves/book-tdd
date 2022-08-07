package service.invoice;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import model.invoice.Invoice;
import model.invoice.Order;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class InvoiceGeneratorTest {

    @Test
    public void shouldGenerateInvoiceWithDiscountedTaxValue() {
        InvoiceGenerator generator = new InvoiceGenerator(List.of());
        Order order = new Order("Marcos", 1000, 1);

        Invoice invoice = generator.generates(order);

        assertEquals(1000 * 0.94, invoice.getValue(), 0.0001);
    }

    @Test
    public void shouldInvokeActionsAfterGeneratingInvoice(){
        ActionAfterGeneratingInvoice action1 = mock(ActionAfterGeneratingInvoice.class);
        ActionAfterGeneratingInvoice action2 = mock(ActionAfterGeneratingInvoice.class);

        InvoiceGenerator generator = new InvoiceGenerator(List.of(action1, action2));
        Order order = new Order("Marcos", 1000, 1);

        Invoice invoice = generator.generates(order);

        //verifying that the method was invoked
        verify(action1).execute(invoice);
        verify(action2).execute(invoice);
    }

    @Test
    public void shouldGenerateInvoiceWithDateOfMonday(){
        SystemClock clock = mock(SystemClock.class);
        when(clock.today()).thenReturn(LocalDate.of(2022, 8, 6));

        InvoiceGenerator generator = new InvoiceGenerator(List.of(), clock);
        Order order = new Order("Marcos", 1000, 1);

        Invoice invoice = generator.generates(order);

        assertEquals(DayOfWeek.MONDAY, invoice.getDate().getDayOfWeek());
    }
}
