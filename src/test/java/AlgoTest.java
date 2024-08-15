import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.dorum.algo.AlgoExpert.*;

public class AlgoTest {
    private static final int[] array = new int[]{2, 1, 3, 5, 8, 6, 4};;


    @Test
    public void binarySearchTest() {
        Arrays.sort(array);
        Assertions.assertEquals(2, binarySearch(array, 3));
        Assertions.assertEquals(-1, binarySearch(array, 0));
    }

    @Test
    public void validateSubSequenceTest() {
        Assertions.assertFalse(validateSubSequence(array, new int[]{3, 1}));
        Assertions.assertTrue(validateSubSequence(array, new int[]{2, 1, 3}));
    }

    @Test
    public void sumOfNumberTest() {
        Assertions.assertArrayEquals(new int[]{0, 4}, sumOfNumber(array, 10).get(0));
        Assertions.assertArrayEquals(new int[]{5, 6}, sumOfNumber(array, 10).get(1));
        Assertions.assertArrayEquals(new int[]{8, 2}, sumOfTwo(array, 10).get(0));
        Assertions.assertArrayEquals(new int[]{4, 6}, sumOfTwo(array, 10).get(1));
    }
}
