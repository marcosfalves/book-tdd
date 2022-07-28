package service;

import model.Functionary;
import model.Role;

public class SalaryCalculator {

    public double calculateSalary(Functionary functionary){
        if (functionary.getRole().equals(Role.DEVELOPER)){
            return tenOrTwentyPercentDiscount(functionary);
        } else if (functionary.getRole().equals(Role.DBA)
                    || functionary.getRole().equals(Role.TESTER)) {
            return fifteenOrTwentyFivePercentDiscount(functionary);
        }

        throw new RuntimeException("Functionary with invalid role");
    }

    private double fifteenOrTwentyFivePercentDiscount(Functionary functionary) {
        if (functionary.getSalary() < 2500){
            return functionary.getSalary() * 0.85;
        }
        return functionary.getSalary() * 0.75;
    }

    private double tenOrTwentyPercentDiscount(Functionary functionary){
        if (functionary.getSalary() > 3000){
            return functionary.getSalary() * 0.8;
        }
        return functionary.getSalary() * 0.9;
    }
}
