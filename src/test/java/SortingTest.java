import java.util.Random;

import static org.dorum.algo.Sorting.mergeSort;

public class SortingTest {
    public static void main(String[] args) {
        int[] inputArray = new int[100000];
        Random random = new Random();
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = random.nextInt(100);
        }
//        System.out.println("Input:" + Arrays.toString(inputArray));
//        bubbleSort(inputArray);
        long start = System.currentTimeMillis();
        mergeSort(inputArray);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
//        System.out.println("Output:" + Arrays.toString(inputArray));
    }
}
