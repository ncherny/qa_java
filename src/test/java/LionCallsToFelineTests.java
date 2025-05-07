import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionCallsToFelineTests {

    @Mock
    Feline feline;
    Lion lion;

    @BeforeEach
    public void prepareLion() {
        try {
            lion = new Lion("Самка", feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkGetKittensReturnsValueFromFeline() {
        int expectedKittens = 1;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittens);
        int actualKittens = lion.getKittens();

        assertEquals(expectedKittens, actualKittens,
                String.format("Calling getKittens results in a different answer from what Feline responds with was expecting '%s', was '%s'", expectedKittens, actualKittens));
    }

    @Test
    public void checkGetFoodReturnsValueFromFeline() {
        try {
            List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
            List<String> actualFood = lion.getFood();
            assertIterableEquals(expectedFood, actualFood,
                    String.format("Calling getFood results in a different answer from what Feline responds with, expected '%s', was '%s'", expectedFood, actualFood));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
