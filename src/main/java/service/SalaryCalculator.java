package service;

import model.Functionary;
import model.Role;

public class SalaryCalculator {

    public double calculateSalary(Functionary functionary){
        if (functionary.getRole() == Role.DEVELOPER) {
            if (functionary.getSalary() > 3000) return 3200.00;
            return 1350.00;
        }
        return 425.00;
    }
}
