package service;

import model.Functionary;

public class TenOrTwentyPercent implements CalculationRule {
    @Override
    public double calculate(Functionary functionary) {
        if (functionary.getSalary() > 3000){
            return functionary.getSalary() * 0.8;
        }
        return functionary.getSalary() * 0.9;
    }
}
