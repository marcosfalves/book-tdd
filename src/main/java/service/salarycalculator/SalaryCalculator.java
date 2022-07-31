package service.salarycalculator;

import model.salarycalculator.Functionary;

public class SalaryCalculator {

    public double calculateSalary(Functionary functionary){
        return functionary.getRole().getRule().calculate(functionary);
    }
}
