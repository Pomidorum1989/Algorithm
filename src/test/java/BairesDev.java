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
        restaurant(array.length, array2);
    }

    @Test
    public void cinemaTest() {
        cinema(5, 12, new int[]{0, 0, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1});
    }

    @Test
    public void timeConverterTest() {
        timeConverter(173635816);
    }
}
