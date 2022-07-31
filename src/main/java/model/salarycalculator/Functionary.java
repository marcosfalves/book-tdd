package model.salarycalculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@With
@Builder
@AllArgsConstructor
public class Functionary {
    private final String name;
    private final double salary;
    private final Role role;
}
