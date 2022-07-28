package service;

import model.Functionary;
import model.Role;

public class SalaryCalculator {

    public double calculateSalary(Functionary functionary){
        if (functionary.getRole().equals(Role.DEVELOPER)){
            if (functionary.getSalary() > 3000){
                return functionary.getSalary() * 0.8;
            }
            return functionary.getSalary() * 0.9;
        } else if (functionary.getRole().equals(Role.DBA)
                    || functionary.getRole().equals(Role.TESTER)) {
            if (functionary.getSalary() < 2500){
                return functionary.getSalary() * 0.85;
            }
            return functionary.getSalary() * 0.75;
        }

        throw new RuntimeException("Funcionário com cargo inválido");
    }
}
