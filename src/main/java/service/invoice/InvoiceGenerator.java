package service.invoice;

import model.invoice.Invoice;
import model.invoice.Order;

import java.time.LocalDate;
import java.util.List;

public class InvoiceGenerator {

    private final List<ActionAfterGeneratingInvoice> actions;

    public InvoiceGenerator(List<ActionAfterGeneratingInvoice> actions) {
        this.actions = actions;
    }

    public Invoice generates(Order order) {
        Invoice invoice = new Invoice(
                order.getCustomer(),
                order.getTotalValue() * 0.94,
                LocalDate.now()
        );

        for (ActionAfterGeneratingInvoice action : actions){
            action.execute(invoice);
        }

        return invoice;
    }
}
