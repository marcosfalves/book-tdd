package service.invoice;

import model.invoice.Invoice;
import model.invoice.Order;
import model.invoice.TableTax;

import java.time.LocalDate;
import java.util.List;

public class InvoiceGenerator {

    private final List<ActionAfterGeneratingInvoice> actions;
    private final Clock clock;
    private final TableTax tableTax;

    public InvoiceGenerator(List<ActionAfterGeneratingInvoice> actions, TableTax tableTax) {
        this.actions = actions;
        this.tableTax = tableTax;
        this.clock = new SystemClock();
    }

    public InvoiceGenerator(List<ActionAfterGeneratingInvoice> actions, Clock clock) {
        this.actions = actions;
        this.clock = clock;
        this.tableTax = new GovernmentTableTaxDao();
    }

    public InvoiceGenerator(List<ActionAfterGeneratingInvoice> actions) {
        this.actions = actions;
        this.clock = new SystemClock();
        this.tableTax = new GovernmentTableTaxDao();
    }

    public Invoice generates(Order order) {

        LocalDate issueDate = switch (clock.today().getDayOfWeek()){
            case SATURDAY -> clock.today().plusDays(2L);
            case SUNDAY -> clock.today().plusDays(1L);
            default -> clock.today();
        };

        Invoice invoice = new Invoice(
                order.getCustomer(),
                order.getTotalValue() *
                            tableTax.forValue(order.getTotalValue()),
                issueDate
        );

        for (ActionAfterGeneratingInvoice action : actions){
            action.execute(invoice);
        }

        return invoice;
    }
}
