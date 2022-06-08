package service;

import model.Functionary;
import model.Role;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryCalculatorTest {

    @Test
    public void ShouldCalculateSalaryForDevelopersWithSalaryBelowLimit(){
        SalaryCalculator calculator = new SalaryCalculator();
        Functionary developer = new Functionary("Marcos", 1500.00, Role.DEVELOPER);

        double salary = calculator.calculateSalary(developer);

        assertEquals(1500.00 * 0.9, salary, 0.00001);
    }

}