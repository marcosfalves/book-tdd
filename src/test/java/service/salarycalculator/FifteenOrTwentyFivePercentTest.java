package service.salarycalculator;

import model.salarycalculator.Functionary;
import model.salarycalculator.Role;
import org.junit.Before;
import org.junit.Test;
import service.salarycalculator.FifteenOrTwentyFivePercent;

import static org.junit.Assert.assertEquals;

public class FifteenOrTwentyFivePercentTest {

    private FifteenOrTwentyFivePercent fifteenOrTwentyFivePercent;

    @Before
    public void setUp() throws Exception {
        fifteenOrTwentyFivePercent = new FifteenOrTwentyFivePercent();
    }

    @Test
    public void shouldCalculateFifteenPercentWhenSalaryBelowLimit(){
        double salaryTotal = FifteenOrTwentyFivePercent.LIMIT_SALARY - 399.00;
        Functionary functionary = new Functionary("Marcos", salaryTotal, Role.TESTER);

        double salary = fifteenOrTwentyFivePercent.calculate(functionary);

        assertEquals(salaryTotal * 0.85, salary, 0.0001);
    }

    @Test
    public void shouldCalculateTwentyFivePercentWhenSalaryAboveLimit(){
        double salaryTotal = FifteenOrTwentyFivePercent.LIMIT_SALARY + 399.00;
        Functionary functionary = new Functionary("Marcos", salaryTotal, Role.DBA);

        double salary = fifteenOrTwentyFivePercent.calculate(functionary);

        assertEquals(salaryTotal * 0.75, salary, 0.0001);
    }

    @Test
    public void shouldCalculateTwentyFivePercentWhenSalaryExactlyLimit(){
        Functionary functionary = new Functionary("Marcos", FifteenOrTwentyFivePercent.LIMIT_SALARY, Role.TESTER);

        double salary = fifteenOrTwentyFivePercent.calculate(functionary);

        assertEquals(FifteenOrTwentyFivePercent.LIMIT_SALARY * 0.75, salary, 0.0001);
    }
}