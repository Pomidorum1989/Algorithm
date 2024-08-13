import org.junit.jupiter.api.Test;

import static org.dorum.algo.Codility.*;

public class CodilityTest {

    @Test
    public void passingCarsTest() {
        System.out.println(passingCars(new int[]{0, 1, 0, 1, 1}));
        System.out.println(passingCars1(new int[]{0, 1, 0, 1, 1}));
    }

    @Test
    public void missingIntegerTest() {
        System.out.println(missingInteger(new int[]{1, 2, 3}));
        System.out.println(missingInteger(new int[]{1, 3, 6, 4, 1, 2}));
    }

    @Test
    public void frogRiverOneTest() {
        System.out.println(frogRiverOne(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }

    @Test
    public void frogJumpTest() {
        System.out.println("Amount of jumps: " + frogJump(10, 85, 30));
    }

    @Test
    public void binaryGapTest() {
        System.out.println(binaryGap(9));
        System.out.println(binaryGap(15));
        System.out.println(binaryGap(1041));
        System.out.println(binaryGap(32));
    }

    @Test
    public void findExtraElementTest() {
        System.out.println(findExtraElement(new int[]{9, 3, 9, 3, 9, 7, 9}));
        System.out.println(findExtraElement(new int[]{2, 2, 3, 3, 4}));
        System.out.println(findExtraElement(new int[]{3, 3, 8, 8, 8, 8, 3}));
        System.out.println(findExtraElement(new int[]{2, 3, 1, 5}));
    }

    @Test
    public void palindromeCheckTest() {
        String text = "abcdcba", text1 = "abcdcbc", text2 = "abccba", text3 = "abccbc";
        System.out.println("Is palindrome: " + palindromeCheck(text));
        System.out.println("Is palindrome: " + palindromeCheck(text1));
        System.out.println("Is palindrome: " + palindromeCheck1(text));
        System.out.println("Is palindrome: " + palindromeCheck1(text1));
        System.out.println("Is palindrome: " + palindromeCheck2(text));
        System.out.println("Is palindrome: " + palindromeCheck2(text1));
        System.out.println("Is palindrome: " + palindromeCheck2(text2));
        System.out.println("Is palindrome: " + palindromeCheck2(text3));
        System.out.println("Is palindrome: " + palindromeCheck3(text, 0));
        System.out.println("Is palindrome: " + palindromeCheck3(text3, 0));
    }

    @Test
    public void findMinimumValueIndexTest() {
        int[] array = new int[]{8, 5, 6, 7, 4, 5, 3, 1};
        findMinimumValueIndex(array);
    }

    @Test
    public void bubbleSortTest() {
        int[] array1 = new int[]{8, 5, 6, 7, 4, 5, 3, 1};
        bubbleSort(array1);
    }
}
