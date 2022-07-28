package model;

import service.CalculationRule;
import service.FifteenOrTwentyFivePercent;
import service.TenOrTwentyPercent;

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
