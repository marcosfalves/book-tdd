package service.invoice;

import model.invoice.Invoice;

public interface ActionAfterGeneratingInvoice {
    void execute(Invoice invoice);
}
