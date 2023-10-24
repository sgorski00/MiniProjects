import org.example.NumberValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberValidatorTest {
    @Test
    public void shouldBeTrueIfStringContainsDigit(){
        //given
        String word = "joh77";

        //when
        boolean result = NumberValidator.doesContainsNumber(word);

        //then
        assertTrue(result);
    }

    @Test
    public void shouldBeFalseIfStringDoesNotContainsDigit(){
        //given
        String word = "john";

        //when
        boolean result = NumberValidator.doesContainsNumber(word);

        //then
        assertFalse(result);
    }
    
    @Test
    public void shouldBeTrueIfNumberIsBetween1And6(){
        //given
        double grade = 4;
        
        //when
        boolean result = NumberValidator.isNumberInRange(grade, 1, 6);
        
        //then
        assertTrue(result);
    }

    @Test
    public void shouldBeFalseIfNumberIsLessThan1(){
        //given
        double grade = 0;

        //when
        boolean result = NumberValidator.isNumberInRange(grade, 1, 6);

        //then
        assertFalse(result);
    }

    @Test
    public void shouldBeFalseIfNumberIsGreaterThan6(){
        //given
        double grade = 6.1;

        //when
        boolean result = NumberValidator.isNumberInRange(grade, 1, 6);

        //then
        assertFalse(result);
    }
}
