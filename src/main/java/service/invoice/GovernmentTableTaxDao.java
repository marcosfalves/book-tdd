package service.invoice;

import model.invoice.TableTax;

public class GovernmentTableTaxDao implements TableTax {
    @Override
    public double forValue(double value) {
        if (value <= 999.00) return 0.98;
        return 0.94;
    }
}
