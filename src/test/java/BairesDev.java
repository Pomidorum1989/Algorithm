import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.dorum.algo.BairesDev.*;

public class BairesDev {

    @Test
    public void restaurantTest() {
        int[][] array = new int[][]{
                {987654423, 4},
                {987654220, 5},
                {987654202, 4},
                {987654250, 1},
                {987654419, 5},
        };

        int[][] array2 = new int[][]{
                {987654171, 3},
                {987654478, 3},
                {987654092, 4},
                {987654421, 3},
                {987654001, 4}
        };
        Assertions.assertEquals(5, restaurant(array.length, array2));
    }

    @Test
    public void cinemaTest() {
        Assertions.assertArrayEquals(new int[]{0, 0, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                cinema(5, 12, new int[]{0, 0, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1}));
    }

    @Test
    public void timeConverterTest() {
        Assertions.assertEquals("5 years 184 days 16 hours 10 minutes 16 seconds", timeConverter(173635816));
    }
}
