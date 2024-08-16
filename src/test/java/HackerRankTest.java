import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(8, superDigit("9875", 4));
        Assertions.assertEquals(9, superDigit("123", 3));
    }

    @Test
    public void counterGameTest() {
        Assertions.assertEquals("Richard", counterGame(1073741824));
        Assertions.assertEquals("Richard", counterGame1(1073741824));
    }

    @Test
    public void balancedSumsTest() {
        Assertions.assertEquals("YES", balancedSums(new ArrayList<>(List.of(1))));
        Assertions.assertEquals("NO", balancedSums(new ArrayList<>(Arrays.asList(1, 2, 3))));
        Assertions.assertEquals("YES", balancedSums(new ArrayList<>(Arrays.asList(1, 2, 3, 3))));
        Assertions.assertEquals("YES", balancedSums1(new ArrayList<>(Arrays.asList(1, 2, 3, 3))));
        Assertions.assertEquals("YES", balancedSums(new ArrayList<>(Arrays.asList(2, 0, 0, 0))));
    }

    @Test
    public void gridChallengeText() {
        Assertions.assertEquals("YES", gridChallenge(new ArrayList<>(Arrays.asList("kc", "iu"))));
        Assertions.assertEquals("NO", gridChallenge(new ArrayList<>(Arrays.asList("uxf", "vof", "hmp"))));
        Assertions.assertEquals("YES", gridChallenge(new ArrayList<>(Arrays.asList("abc", "lmp", "qrt"))));
        Assertions.assertEquals("YES", gridChallenge(new ArrayList<>(Arrays.asList("ebacd", "fghij", "olmkn", "trpqs", "xywuv"))));
    }

    @Test
    public void maxMinTest() {
        Assertions.assertEquals(1, maxMin(2, new ArrayList<>(Arrays.asList(1, 4, 7, 2))));
        Assertions.assertEquals(3, maxMin(4, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 20, 30, 40, 100, 200))));
    }

    @Test
    public void caesarCipherTest() {
       Assertions.assertEquals("defghijklmnopqrstuvwxyzabc", caesarCipher("abcdefghijklmnopqrstuvwxyz", 3));
    }

    @Test
    public void findZigZagSequenceTest() {
        findZigZagSequence(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public void sockMerchantTest() {
        Assertions.assertEquals(3, sockMerchant(9, new ArrayList<>(Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20))));
        Assertions.assertEquals(2, sockMerchant(7, new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 3, 2))));
    }

    @Test
    public void lexicographicalCounterTest() {
        Assertions.assertEquals(1, lexicographicalCounter("amazon", 3));
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
        Assertions.assertEquals("YES", twoArrays(1, Arrays.asList(0, 1), Arrays.asList(0, 2)));
    }

    @Test
    public void flippingBitsTest() {
        Assertions.assertEquals(4294967286L, flippingBits(9));
    }

    @Test
    public void plusMinusTest() {
        plusMinus(new ArrayList<>(Arrays.asList(1, 1, 0, -1, -1)));
    }

    @Test
    public void miniMaxSumTest() {
        Assertions.assertEquals("2063136757-2744467344", miniMaxSum(new ArrayList<>(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625))));
    }

    @Test
    public void miniMaxSum2Test() {
        Assertions.assertEquals("2063136757-2744467344", miniMaxSum2(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625)));
    }

    @Test
    public void timeConversionTest() {
        Assertions.assertEquals("19:05:45", timeConversion("07:05:45PM"));
        Assertions.assertEquals("07:05:45", timeConversion("07:05:45AM"));
        Assertions.assertEquals("12:05:45", timeConversion("12:05:45PM"));
        Assertions.assertEquals("00:05:45", timeConversion("12:05:45AM"));
    }

    @Test
    public void matchingStringsTest() {
        Assertions.assertIterableEquals(List.of(2, 1, 0), matchingStrings(Arrays.asList("ab", "ab", "abc"), Arrays.asList("ab", "abc", "bc")));
    }

    @Test
    public void lonelyIntegerTest() {
        Assertions.assertEquals(3, lonelyInteger(new ArrayList<>(Arrays.asList(1, 1, 2, 3, 2, 4, 4))));
        Assertions.assertEquals(2, lonelyInteger(new ArrayList<>(Arrays.asList(0, 0, 1, 2, 1))));
    }

    @Test
    public void diagonalDifferenceTest() {
        Assertions.assertEquals(2, (diagonalDifference(Arrays.asList(Arrays.asList(1, 2, 3),
                                                                              Arrays.asList(4, 5, 6),
                                                                              Arrays.asList(9, 8, 9)))));
    }

    @Test
    public void pangramsTest() {
        Assertions.assertEquals("pangram", pangrams("We promptly judged antique ivory buckles for the next prize"));
        Assertions.assertEquals("not pangram", pangrams("We promptly judged"));
    }

    @Test
    public void birthdayTest() {
        Assertions.assertEquals(2, birthday(new ArrayList<>(Arrays.asList(2, 2, 1, 3, 2)), 4, 2));
        Assertions.assertEquals(1, birthday(new ArrayList<>(List.of(4)), 4, 1));
        Assertions.assertEquals(3, birthday(new ArrayList<>(Arrays.asList(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1)),
                18, 7));
    }

    @Test
    public void staircaseTest() {
        staircaseReverted(4);
        staircase(4);
    }

    @Test
    public void isFibonacciTest() {
        Assertions.assertTrue(isFibonacci(new int[]{1, 2, 3, 5, 8, 13, 21, 34, 55}));
        createFibonacciSequence(10);
        fibonacciRecursion(10);
    }
}
