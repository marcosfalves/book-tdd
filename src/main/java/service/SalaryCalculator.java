package service;

import model.Functionary;
import model.Role;

public class SalaryCalculator {

    public double calculateSalary(Functionary functionary){
        if (functionary.getSalary() > 3000){
            return functionary.getSalary() * 0.8;
        }
        return functionary.getSalary() * 0.9;
    }
}
