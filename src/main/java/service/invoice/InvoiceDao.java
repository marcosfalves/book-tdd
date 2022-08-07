package service.invoice;

import model.invoice.Invoice;

public class InvoiceDao implements ActionAfterGeneratingInvoice {
    @Override
    public void execute(Invoice invoice) {
        //persist invoice in Db
    }
}