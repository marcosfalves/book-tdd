package converter;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberConverter {

    private static Map<Character, Integer> table = new HashMap<>(){{
        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('C',100);
        put('D',500);
        put('M',1000);
    }};

    public int convert(String romanNumber) {
        int accumulator    = 0;
        int lastOnTheRight = 0;
        for (int i = romanNumber.length() -1; i >= 0 ; i--) {
            int current = table.get(romanNumber.charAt(i));

            int multiplier = (current < lastOnTheRight ? -1 : 1);
            accumulator += current * multiplier;

            lastOnTheRight = current;
        }
        return accumulator;
    }
}
