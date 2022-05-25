package converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumberConverterTest {

    @Test
    public void ShouldConverterSymbolI(){
        RomanNumberConverter converter = new RomanNumberConverter();
        int number = converter.convert("I");

        assertEquals(1, number);
    }

    @Test
    public void ShouldConverterSymbolV(){
        RomanNumberConverter converter = new RomanNumberConverter();
        int number = converter.convert("V");

        assertEquals(5, number);
    }

    @Test
    public void ShouldConverterTwoSymbolHowII(){
        RomanNumberConverter converter = new RomanNumberConverter();
        int number = converter.convert("II");

        assertEquals(2, number);
    }

    @Test
    public void ShouldConverterFourSymbolTwoByTwoHowXXII(){
        RomanNumberConverter converter = new RomanNumberConverter();
        int number = converter.convert("XXII");

        assertEquals(22, number);
    }

    @Test
    public void ShouldConverterNumberHowIX(){
        RomanNumberConverter converter = new RomanNumberConverter();
        int number = converter.convert("IX");

        assertEquals(9, number);
    }

    @Test
    public void ShouldConverterComplexesNumberHowXXIV(){
        RomanNumberConverter converter = new RomanNumberConverter();
        int number = converter.convert("XXIV");

        assertEquals(24, number);
    }
}