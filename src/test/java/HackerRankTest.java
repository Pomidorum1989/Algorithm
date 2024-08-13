import org.dorum.algo.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.dorum.algo.HackerRank.*;

public class HackerRankTest {
    public static void main(String[] args) {

        HackerRank.SinglyLinkedList list = new HackerRank.SinglyLinkedList();
        list.insertNode(16);
        list.insertNode(13);
        list.insertNode(7);
        printList(list.head);
        printList(insertNodeAtPosition(list.head, 1, 2));

        printList(reverse(list.head));

        System.out.println(superDigit("9875", 4));
        System.out.println(superDigit("123", 3));

        System.out.println(counterGame(1073741824));
        System.out.println(counterGame1(1073741824));

        System.out.println(balancedSums(new ArrayList<>(List.of(1))));
        System.out.println(balancedSums(new ArrayList<>(Arrays.asList(1, 2, 3))));
        System.out.println(balancedSums(new ArrayList<>(Arrays.asList(1, 2, 3, 3))));
        System.out.println(balancedSums1(new ArrayList<>(Arrays.asList(1, 2, 3, 3))));
        System.out.println(balancedSums(new ArrayList<>(Arrays.asList(2, 0, 0, 0))));

        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("kc", "iu"))));
        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("uxf", "vof", "hmp"))));
        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("abc", "lmp", "qrt"))));
        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("ebacd", "fghij", "olmkn", "trpqs", "xywuv"))));

        System.out.println(maxMin(2, new ArrayList<>(Arrays.asList(1, 4, 7, 2))));
        System.out.println(maxMin(4, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 20, 30, 40, 100, 200))));

        System.out.println(caesarCipher("abcdefghijklmnopqrstuvwxyz", 3));

        findZigZagSequence(new int[]{1, 2, 3, 4, 5, 6, 7});

        System.out.println(sockMerchant(9, new ArrayList<>(Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20))));
        System.out.println(sockMerchant(7, new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 3, 2))));

        System.out.println(lexicographicalCounter("amazon", 3));

        xor();

        System.out.println(countingSort(Arrays.asList(1, 1, 3, 2, 1)));

        System.out.println(twoArrays(1, Arrays.asList(0, 1), Arrays.asList(0, 2)));

        System.out.println(flippingBits(9));

        plusMinus(new ArrayList<>(Arrays.asList(1, 1, 0, -1, -1)));
        miniMaxSum(new ArrayList<>(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625)));
        System.out.println(timeConversion("07:05:45PM"));
        System.out.println(timeConversion("07:05:45AM"));
        System.out.println(timeConversion("12:05:45PM"));
        System.out.println(timeConversion("12:05:45AM"));

        System.out.println(matchingStrings(Arrays.asList("ab", "ab", "abc"), Arrays.asList("ab", "abc", "bc")));

        System.out.println(HackerRank.lonelyInteger(new ArrayList<>(Arrays.asList(1, 1, 2, 3, 2, 4, 4))));
        System.out.println(HackerRank.lonelyInteger(new ArrayList<>(Arrays.asList(0, 0, 1, 2, 1))));

        System.out.println(diagonalDifference(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
                Arrays.asList(9, 8, 9))));

        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
        System.out.println(pangrams("We promptly judged"));

        System.out.println(birthday(new ArrayList<>(Arrays.asList(2, 2, 1, 3, 2)), 4, 2));
        System.out.println(birthday(new ArrayList<>(List.of(4)), 4, 1));
        System.out.println(birthday(new ArrayList<>(Arrays.asList(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1)),
                18, 7));

        staircaseReverted(4);
        staircase(4);

        miniMaxSum2(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625));

        System.out.println(isFibonacci(new int[]{1, 2, 3, 5, 8, 13, 21, 34, 55}));
        createFibonacciSequence(10);

        fibonacciRecursion(10);
    }
}
