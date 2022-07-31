package service.salarycalculator;

import model.salarycalculator.Functionary;

public class FifteenOrTwentyFivePercent implements CalculationRule {

    public static final double LIMIT_SALARY = 2_500;

    @Override
    public double calculate(Functionary functionary) {
        if (functionary.getSalary() < LIMIT_SALARY){
            return functionary.getSalary() * 0.85;
        }
        return functionary.getSalary() * 0.75;
    }
}
