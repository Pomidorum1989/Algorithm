import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.dorum.algo.Codility.*;

public class CodilityTest {
    private static final int[] ARRAY = new int[]{8, 5, 6, 7, 4, 5, 3, 1};

    @Test
    public void passingCarsTest() {
        Assertions.assertEquals(5, passingCars(new int[]{0, 1, 0, 1, 1}));
        Assertions.assertEquals(5, passingCars1(new int[]{0, 1, 0, 1, 1}));
    }

    @Test
    public void missingIntegerTest() {
        Assertions.assertEquals(4, missingInteger(new int[]{1, 2, 3}));
        Assertions.assertEquals(5, missingInteger(new int[]{1, 3, 6, 4, 1, 2}));
    }

    @Test
    public void frogRiverOneTest() {
        Assertions.assertEquals(6, frogRiverOne(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }

    @Test
    public void frogJumpTest() {
        Assertions.assertEquals(3, frogJump(10, 85, 30));
    }

    @Test
    public void binaryGapTest() {
        Assertions.assertEquals(2, binaryGap(9));
        Assertions.assertEquals(0, binaryGap(15));
        Assertions.assertEquals(5, binaryGap(1041));
        Assertions.assertEquals(0, binaryGap(32));
    }

    @Test
    public void findExtraElementTest() {
        Assertions.assertEquals(7, findExtraElement(new int[]{9, 3, 9, 3, 9, 7, 9}));
        Assertions.assertEquals(4, findExtraElement(new int[]{2, 2, 3, 3, 4}));
        Assertions.assertEquals(3, findExtraElement(new int[]{3, 3, 8, 8, 8, 8, 3}));
        Assertions.assertEquals(1, findExtraElement(new int[]{2, 3, 1, 5}));
    }

    @Test
    public void palindromeCheckTest() {
        String text = "abcdcba", text1 = "abcdcbc", text2 = "abccba", text3 = "abccbc";
        Assertions.assertTrue(palindromeCheck(text));
        Assertions.assertFalse(palindromeCheck(text1));
        Assertions.assertTrue(palindromeCheck1(text));
        Assertions.assertFalse(palindromeCheck1(text1));
        Assertions.assertTrue(palindromeCheck2(text));
        Assertions.assertFalse(palindromeCheck2(text1));
        Assertions.assertTrue(palindromeCheck2(text2));
        Assertions.assertFalse(palindromeCheck2(text3));
        Assertions.assertTrue(palindromeCheck3(text, 0));
        Assertions.assertFalse(palindromeCheck3(text3, 0));
    }

    @Test
    public void findMinimumValueIndexTest() {
        Assertions.assertEquals(6, findMinimumValueIndex(ARRAY));
        Assertions.assertEquals(6, findMinimumValueIndex1(ARRAY));
    }

    @Test
    public void bubbleSortTest() {
        Assertions.assertArrayEquals(new int[]{8, 7, 6, 5, 5, 4, 3, 1}, bubbleSort(ARRAY));
    }
}
