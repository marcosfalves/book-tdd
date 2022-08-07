package service.invoice;

import model.invoice.Invoice;
import model.invoice.Order;

import java.time.LocalDate;

public class InvoiceGenerator {

    private InvoiceDao dao;
    private SAP sap;

    public InvoiceGenerator(InvoiceDao dao, SAP sap) {
        this.dao = dao;
        this.sap = sap;
    }

    public Invoice generates(Order order) {
        Invoice invoice = new Invoice(
                order.getCustomer(),
                order.getTotalValue() * 0.94,
                LocalDate.now()
        );

        dao.persist(invoice);
        sap.send(invoice);

        return invoice;
    }
}
