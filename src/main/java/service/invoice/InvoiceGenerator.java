package service.invoice;

import model.invoice.Invoice;
import model.invoice.Order;

import java.time.LocalDate;
import java.util.List;

public class InvoiceGenerator {

    private final List<ActionAfterGeneratingInvoice> actions;
    private final Clock clock;

    public InvoiceGenerator(List<ActionAfterGeneratingInvoice> actions, Clock clock) {
        this.actions = actions;
        this.clock = clock;
    }
    public InvoiceGenerator(List<ActionAfterGeneratingInvoice> actions) {
       this(actions, new SystemClock());
    }

    public Invoice generates(Order order) {

        LocalDate issueDate = switch (clock.today().getDayOfWeek()){
            case SATURDAY -> clock.today().plusDays(2L);
            case SUNDAY -> clock.today().plusDays(1L);
            default -> clock.today();
        };

        Invoice invoice = new Invoice(
                order.getCustomer(),
                order.getTotalValue() * 0.94,
                issueDate
        );

        for (ActionAfterGeneratingInvoice action : actions){
            action.execute(invoice);
        }

        return invoice;
    }
}
