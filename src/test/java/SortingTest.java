import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.dorum.algo.Sorting.bubbleSort;
import static org.dorum.algo.Sorting.mergeSort;

public class SortingTest {
    private final static int[] INPUT_ARRAY;

    static {
        INPUT_ARRAY = new int[100000];
        Random random = new Random();
        for (int i = 0; i < INPUT_ARRAY.length; i++) {
            INPUT_ARRAY[i] = random.nextInt(100);
        }
    }

    @Test
    public void mergeSortTest() {
        long start = System.currentTimeMillis();
        mergeSort(INPUT_ARRAY);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);

    }

    @Test
    public void bubbleSortTest() {
        System.out.println("Input:" + Arrays.toString(INPUT_ARRAY));
        bubbleSort(INPUT_ARRAY);
        System.out.println("Output:" + Arrays.toString(INPUT_ARRAY));
    }
}
