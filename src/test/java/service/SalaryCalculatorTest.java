package service;

import model.Functionary;
import model.Role;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryCalculatorTest {

    @Test
    public void shouldCalculateSalaryForDevelopersWithSalaryBelowLimit(){
        SalaryCalculator calculator = new SalaryCalculator();
        Functionary developer = new Functionary("Marcos", 1500.00, Role.DEVELOPER);

        double salary = calculator.calculateSalary(developer);

        assertEquals(1500.00 * 0.9, salary, 0.00001);
    }

    @Test
    public void shouldCalculateSalaryForDevelopersWithSalaryAboveLimit(){
        SalaryCalculator calculator = new SalaryCalculator();
        Functionary developer = new Functionary("Marcos", 4000.00, Role.DEVELOPER);

        double salary = calculator.calculateSalary(developer);

        assertEquals(4000.00 * 0.8, salary, 0.00001);
    }

    @Test
    public void shouldCalculateSalaryForDBAWithSalaryBelowLimit(){
        SalaryCalculator calculator = new SalaryCalculator();
        Functionary developer = new Functionary("Marcos", 1500.00, Role.DBA);

        double salary = calculator.calculateSalary(developer);

        assertEquals(1500.00 * 0.85, salary, 0.00001);
    }

    @Test
    public void shouldCalculateSalaryForDBAWithSalaryAboveLimit(){
        SalaryCalculator calculator = new SalaryCalculator();
        Functionary developer = new Functionary("Marcos", 4500.00, Role.DBA);

        double salary = calculator.calculateSalary(developer);

        assertEquals(4500.00 * 0.75, salary, 0.00001);
    }

    @Test
    public void shouldCalculateSalaryForTesterWithSalaryBelowLimit(){
        SalaryCalculator calculator = new SalaryCalculator();
        Functionary developer = new Functionary("Marcos", 1500.00, Role.TESTER);

        double salary = calculator.calculateSalary(developer);

        assertEquals(1500.00 * 0.85, salary, 0.00001);
    }

    @Test
    public void shouldCalculateSalaryForTesterWithSalaryAboveLimit(){
        SalaryCalculator calculator = new SalaryCalculator();
        Functionary developer = new Functionary("Marcos", 4500.00, Role.TESTER);

        double salary = calculator.calculateSalary(developer);

        assertEquals(4500.00 * 0.75, salary, 0.00001);
    }

}