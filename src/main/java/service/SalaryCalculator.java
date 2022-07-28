package service;

import model.Functionary;
import model.Role;

public class SalaryCalculator {

    public double calculateSalary(Functionary functionary){
        return functionary.getRole().getRule().calculate(functionary);
    }
}
