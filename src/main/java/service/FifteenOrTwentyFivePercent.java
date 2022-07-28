package service;

import model.Functionary;

public class FifteenOrTwentyFivePercent implements CalculationRule {
    @Override
    public double calculate(Functionary functionary) {
        if (functionary.getSalary() < 2500){
            return functionary.getSalary() * 0.85;
        }
        return functionary.getSalary() * 0.75;
    }
}
