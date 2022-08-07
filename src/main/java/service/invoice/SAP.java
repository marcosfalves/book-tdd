package service.invoice;

import model.invoice.Invoice;

public class SAP implements ActionAfterGeneratingInvoice {
    @Override
    public void execute(Invoice invoice) {
        //Send Invoice to SAP
    }
}
