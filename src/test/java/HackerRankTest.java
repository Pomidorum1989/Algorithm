import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.dorum.algo.HackerRank.*;

public class HackerRankTest {
    @Test
    public void reverseLinkedListTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertNode(16);
        list.insertNode(13);
        list.insertNode(7);
        printList(list.head);
        printList(insertNodeAtPosition(list.head, 1, 2));
        printList(reverse(list.head));
    }

    @Test
    public void superDigitTest() {
        System.out.println(superDigit("9875", 4));
        System.out.println(superDigit("123", 3));
    }

    @Test
    public void counterGameTest() {
        System.out.println(counterGame(1073741824));
        System.out.println(counterGame1(1073741824));
    }

    @Test
    public void balancedSumsTest() {
        System.out.println(balancedSums(new ArrayList<>(List.of(1))));
        System.out.println(balancedSums(new ArrayList<>(Arrays.asList(1, 2, 3))));
        System.out.println(balancedSums(new ArrayList<>(Arrays.asList(1, 2, 3, 3))));
        System.out.println(balancedSums1(new ArrayList<>(Arrays.asList(1, 2, 3, 3))));
        System.out.println(balancedSums(new ArrayList<>(Arrays.asList(2, 0, 0, 0))));
    }

    @Test
    public void gridChallengeText() {
        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("kc", "iu"))));
        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("uxf", "vof", "hmp"))));
        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("abc", "lmp", "qrt"))));
        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("ebacd", "fghij", "olmkn", "trpqs", "xywuv"))));
    }

    @Test
    public void maxMinTest() {
        System.out.println(maxMin(2, new ArrayList<>(Arrays.asList(1, 4, 7, 2))));
        System.out.println(maxMin(4, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 20, 30, 40, 100, 200))));
    }

    @Test
    public void caesarCipherTest() {
        System.out.println(caesarCipher("abcdefghijklmnopqrstuvwxyz", 3));
    }

    @Test
    public void findZigZagSequenceTest() {
        findZigZagSequence(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public void sockMerchantTest() {
        System.out.println(sockMerchant(9, new ArrayList<>(Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20))));
        System.out.println(sockMerchant(7, new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 3, 2))));
    }

    @Test
    public void lexicographicalCounterTest() {
        System.out.println(lexicographicalCounter("amazon", 3));
    }

    @Test
    public void xorTest() {
        xor();
    }

    @Test
    public void countingSortTest() {
        System.out.println(countingSort(Arrays.asList(1, 1, 3, 2, 1)));
    }

    @Test
    public void reverseTest() {
        System.out.println(twoArrays(1, Arrays.asList(0, 1), Arrays.asList(0, 2)));
    }

    @Test
    public void flippingBitsTest() {
        System.out.println(flippingBits(9));
    }

    @Test
    public void plusMinusTest() {
        plusMinus(new ArrayList<>(Arrays.asList(1, 1, 0, -1, -1)));
    }

    @Test
    public void miniMaxSumTest() {
        miniMaxSum(new ArrayList<>(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625)));
    }

    @Test
    public void miniMaxSum2Test() {
        miniMaxSum2(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625));
    }

    @Test
    public void timeConversionTest() {
        System.out.println(timeConversion("07:05:45PM"));
        System.out.println(timeConversion("07:05:45AM"));
        System.out.println(timeConversion("12:05:45PM"));
        System.out.println(timeConversion("12:05:45AM"));
    }

    @Test
    public void matchingStringsTest() {
        System.out.println(matchingStrings(Arrays.asList("ab", "ab", "abc"), Arrays.asList("ab", "abc", "bc")));
    }

    @Test
    public void lonelyIntegerTest() {
        System.out.println(lonelyInteger(new ArrayList<>(Arrays.asList(1, 1, 2, 3, 2, 4, 4))));
        System.out.println(lonelyInteger(new ArrayList<>(Arrays.asList(0, 0, 1, 2, 1))));
    }

    @Test
    public void diagonalDifferenceTest() {
        System.out.println(diagonalDifference(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
                Arrays.asList(9, 8, 9))));
    }

    @Test
    public void pangramsTest() {
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
        System.out.println(pangrams("We promptly judged"));
    }

    @Test
    public void birthdayTest() {
        System.out.println(birthday(new ArrayList<>(Arrays.asList(2, 2, 1, 3, 2)), 4, 2));
        System.out.println(birthday(new ArrayList<>(List.of(4)), 4, 1));
        System.out.println(birthday(new ArrayList<>(Arrays.asList(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1)),
                18, 7));
    }

    @Test
    public void staircaseTest() {
        staircaseReverted(4);
        staircase(4);
    }

    @Test
    public void isFibonacciTest() {
        System.out.println(isFibonacci(new int[]{1, 2, 3, 5, 8, 13, 21, 34, 55}));
        createFibonacciSequence(10);
        fibonacciRecursion(10);
    }
}
