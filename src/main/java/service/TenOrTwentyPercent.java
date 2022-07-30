package service;

import model.Functionary;

public class TenOrTwentyPercent implements CalculationRule {

    public static final double LIMIT_SALARY = 3_000;

    @Override
    public double calculate(Functionary functionary) {
        if (functionary.getSalary() > LIMIT_SALARY){
            return functionary.getSalary() * 0.8;
        }
        return functionary.getSalary() * 0.9;
    }
}
