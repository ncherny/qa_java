import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class LionManeSetupTests {
    private static final String EXPECTED_INVALID_SEX_EXCEPTION_STRING = "Используйте допустимые значения пола животного - самец или самка";

    @ParameterizedTest(name = "{index}. Test data: Lion sex={0}; Has Mane={1}")
    @CsvSource({"Самка, false", "Самец ,true"})
    public void checkManeSetupPositive(String lionSex, boolean expectedHaveMane) {
        try {
            Lion lion = new Lion(lionSex, new Feline());
            assertEquals(expectedHaveMane, lion.doesHaveMane(),
                    String.format("Creating lion with sex '%s' has mane was set to '%s', but was expected to be '%s'", lionSex, lion.doesHaveMane(), expectedHaveMane));
        }
        catch (Exception e) {
            fail(String.format("Creating lion with sex '%s' resulted in exception '%s'", lionSex, e.getMessage()));
        }
    }

    @ParameterizedTest(name = "{index}. Test data: Lion sex={0}")
    @ValueSource(strings = {"", "СамкаСамец"})
    public void checkManeSetupNegative(String lionSex) {
        try {
            Lion lion = new Lion(lionSex, new Feline());
            fail(String.format("Creating lion with sex '%s' didn't result in Exception, but was supposed to", lionSex));
        }
        catch (Exception e) {
            assertEquals(EXPECTED_INVALID_SEX_EXCEPTION_STRING, e.getMessage(),
                    String.format("Creating lion with sex '%s' resulted in exception '%s' instead of '%s'", lionSex, e.getMessage(), EXPECTED_INVALID_SEX_EXCEPTION_STRING));
        }
    }
}
