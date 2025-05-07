import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTests {

    @Spy
    Feline feline = new Feline();

    @Test
    public void checkEatMeatCallsGetFood() {
        try {
            List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
            List<String> actualFood = feline.eatMeat();
            assertIterableEquals(expectedFood, actualFood,
                    String.format("Calling eatMeat results in a different answer from what getFood with animal type 'Хищник' responds with, expected '%s', was '%s'", expectedFood, actualFood));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkGetFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily, String.format("Expected '%s' family, actually was '%s'", expectedFamily, actualFamily));
    }
}
