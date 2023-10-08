import org.example.NumberCheck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberCheckTest {
    @Test
    public void shouldBeTrueIfStringContainsDigit(){
        //given
        String word = "joh77";

        //when
        boolean result = NumberCheck.doesContainsNumber(word);

        //then
        assertTrue(result);
    }

    @Test
    public void shouldBeFalseIfStringDoesNotContainsDigit(){
        //given
        String word = "john";

        //when
        boolean result = NumberCheck.doesContainsNumber(word);

        //then
        assertFalse(result);
    }
}
