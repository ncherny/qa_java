import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@ExtendWith(MockitoExtension.class)
public class CatTests {

    @Mock
    Feline feline;
    Cat cat;

    @BeforeEach
    public void setupCat() {
        cat = new Cat(feline);
    }

    @Test
    public void checkGetSound() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound, String.format("Expected '%s' sound, actually was '%s'", expectedSound, actualSound));
    }

    @Test
    public void checkGetFoodReturnsValueFromPredator() {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        try {
            Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
            List<String> actualFood = cat.getFood();
            assertIterableEquals(expectedFood, actualFood,
                    String.format("Calling getFood results in a different answer from what Feline responds with, expected '%s', was '%s'", expectedFood, actualFood));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
