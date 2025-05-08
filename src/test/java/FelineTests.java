import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTests {


    Feline feline = new Feline();

    @Test
    public void checkEatMeatCallsGetFoodTest() {
        try {
            List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
            List<String> actualFood = feline.eatMeat();
            assertIterableEquals(expectedFood, actualFood,
                    String.format("Expected meat '%s', actually was '%s'", expectedFood, actualFood));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkGetFamilyTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily, String.format("Expected '%s' family, actually was '%s'", expectedFamily, actualFamily));
    }
}
