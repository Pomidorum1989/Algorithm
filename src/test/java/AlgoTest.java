import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.dorum.algo.AlgoExpert.*;

public class AlgoTest {
    private static final int[] array;

    static {
        array = new int[]{2, 1, 3, 5, 8, 6, 4};
        Arrays.sort(array);
    }

    @Test
    public void binarySearchTest() {
        System.out.println(binarySearch(array, 0));
    }

    @Test
    public void validateSubSequenceTest() {
        System.out.println(validateSubSequence(array, new int[]{}));
    }

    @Test
    public void sumOfNumberTest() {
        sumOfNumber(array, 10);
    }

    @Test
    public void sumOfTwoTest() {
        sumOfTwo(array, 10);
    }
}
