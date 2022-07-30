package service;

import model.Functionary;
import model.Role;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TenOrTwentyPercentTest {

    private TenOrTwentyPercent tenOrTwentyPercent;

    @Before
    public void setUp() throws Exception {
        tenOrTwentyPercent = new TenOrTwentyPercent();
    }

    @Test
    public void shouldCalculateTenPercentWhenSalaryBelowLimit(){
        double salaryTotal = TenOrTwentyPercent.LIMIT_SALARY - 200.00;
        Functionary functionary = new Functionary("Marcos", salaryTotal, Role.DEVELOPER);

        double salary = tenOrTwentyPercent.calculate(functionary);

        assertEquals(salaryTotal * 0.90, salary, 0.0001);
    }

    @Test
    public void shouldCalculateTwentyPercentWhenSalaryAboveLimit(){
        double salaryTotal = TenOrTwentyPercent.LIMIT_SALARY + 200.00;
        Functionary functionary = new Functionary("Marcos", salaryTotal, Role.DEVELOPER);

        double salary = tenOrTwentyPercent.calculate(functionary);

        assertEquals(salaryTotal * 0.80, salary, 0.0001);
    }

    @Test
    public void shouldCalculateTenPercentWhenSalaryExactlyLimit(){
        Functionary functionary = new Functionary("Marcos", TenOrTwentyPercent.LIMIT_SALARY, Role.DEVELOPER);

        double salary = tenOrTwentyPercent.calculate(functionary);

        assertEquals(TenOrTwentyPercent.LIMIT_SALARY * 0.90, salary, 0.0001);
    }
}