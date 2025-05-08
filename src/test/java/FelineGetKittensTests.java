import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineGetKittensTests {

    Feline feline = new Feline();

    @Test
    public void checkGetKittensNoArgumentsTest() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals(expectedKittens, actualKittens, String.format("When calling getKittens without arguments response was %d, instead of %d", actualKittens, expectedKittens));
    }

    @ParameterizedTest(name = "{index}. Test data: Kittens={0}")
    @ValueSource(ints = {1, 5})
    public void checkGetKittensTest(int kittens) {
        int actualKittens = feline.getKittens(kittens);
        assertEquals(kittens, actualKittens, String.format("When passing %d kittens, response was %d, instead of %d", kittens, actualKittens, kittens));
    }
}
