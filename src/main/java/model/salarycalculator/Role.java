package model.salarycalculator;

import service.salarycalculator.CalculationRule;
import service.salarycalculator.FifteenOrTwentyFivePercent;
import service.salarycalculator.TenOrTwentyPercent;

public enum Role {
    DEVELOPER(new TenOrTwentyPercent()),
    DBA(new FifteenOrTwentyFivePercent()),
    TESTER(new FifteenOrTwentyFivePercent());

    private final CalculationRule rule;

    Role(CalculationRule rule) {
        this.rule = rule;
    }

    public CalculationRule getRule(){
        return this.rule;
    }
}
