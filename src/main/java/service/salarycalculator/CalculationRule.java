package service.salarycalculator;

import model.salarycalculator.Functionary;

public interface CalculationRule {
    double calculate(Functionary functionary);
}
