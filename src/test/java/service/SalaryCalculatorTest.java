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

    @Test
    public void ShouldCalculateSalaryForDevelopersWithSalaryAboveLimit(){
        SalaryCalculator calculator = new SalaryCalculator();
        Functionary developer = new Functionary("Marcos", 4000.00, Role.DEVELOPER);

        double salary = calculator.calculateSalary(developer);

        assertEquals(4000.00 * 0.8, salary, 0.00001);
    }

    @Test
    public void ShouldCalculateSalaryForDBAWithSalaryBelowLimit(){
        SalaryCalculator calculator = new SalaryCalculator();
        Functionary developer = new Functionary("Marcos", 500.00, Role.DBA);

        double salary = calculator.calculateSalary(developer);

        assertEquals(500.00 * 0.85, salary, 0.00001);
    }

}