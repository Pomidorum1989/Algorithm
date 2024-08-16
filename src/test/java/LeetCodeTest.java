import org.dorum.utils.MapToFileAppender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.dorum.algo.LeetCode.*;

public class LeetCodeTest {
    @Test
    public void generateReadmeMD() {
        MapToFileAppender.appendAfterStatement(MapToFileAppender.TaskType.LEET_CODE);
        MapToFileAppender.appendAfterStatement(MapToFileAppender.TaskType.HACKER_RANK);
        MapToFileAppender.appendAfterStatement(MapToFileAppender.TaskType.CODILITY);
        MapToFileAppender.appendAfterStatement(MapToFileAppender.TaskType.ALGO_EXPERT);
    }

    @Test
    public void compressTest() {
        Assertions.assertEquals(6, compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        Assertions.assertEquals(4, compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        Assertions.assertEquals(1, compress(new char[]{'a'}));
    }

    @Test
    public void removeElementTest() {
        Assertions.assertEquals(2, removeElement(new int[]{3, 2, 2, 3}, 3));
        Assertions.assertEquals(5, removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    @Test
    public void mergeTest() {
        Assertions.assertEquals(new int[]{1, 2, 2, 3, 5, 6},
                merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3));
    }

    @Test
    public void Test() {
        Assertions.assertEquals("fl", longestCommonPart(new String[]{"flower", "flow", "flight"}),
                "Incorrect longest common prefix");
    }

    @Test
    public void strStrTest() {
        Assertions.assertEquals(0, strStr("a", "a"));
        Assertions.assertEquals(0, strStr1("a", "a"));
    }

    @Test
    public void myAtoiTest() {
        System.out.println(myAtoi("00000-42a1234"));
        System.out.println(myAtoi("1"));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi(".1"));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("-+12"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("      -42"));
        System.out.println(myAtoi("      42"));
        System.out.println(myAtoi("+42"));
    }

    @Test
    public void isAnagramTest() {
        Assertions.assertFalse(isAnagram1("ac", "bb"));
        Assertions.assertFalse(isAnagram1("a", "ab"));
        Assertions.assertTrue(isAnagram1("anagram", "nagaram"));
        Assertions.assertFalse(isAnagram1("rat", "car"));
        Assertions.assertTrue(isAnagram3("anagram", "nagaram"));

    }

    @Test
    public void isPalindromeTest() {
        Assertions.assertTrue(isPalindrome1("AB$BA$$"));
        Assertions.assertTrue(isPalindrome2("A man, a plan, a canal: Panama"));
        Assertions.assertTrue(isPalindrome2("ab_a"));
    }

    @Test
    public void firstUniqueCharTest() {
        Assertions.assertEquals(0, firstUniqueChar("leetcode"));
        Assertions.assertEquals(0, firstUniqueChar1("leetcode"));
        Assertions.assertEquals(-1, firstUniqueChar("aadadaad"));
        Assertions.assertEquals(-1, firstUniqueChar1("aadadaad"));
    }

    @Test
    public void reverseTest() {
        Assertions.assertEquals(4321, reverse1(1234));
        Assertions.assertEquals(-4321, reverse1(-1234));
        Assertions.assertEquals(54321, reverse1(12345));
        Assertions.assertArrayEquals(new int[]{5, 4, 3, 2, 1}, reverse(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void moveZeroesTest() {
        Assertions.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, moveZeroes(new int[]{0, 1, 0, 3, 12}));
        Assertions.assertArrayEquals(new int[]{1, 0, 0}, moveZeroes(new int[]{0, 0, 1}));
    }

    @Test
    public void twoSumTest() {
        Assertions.assertArrayEquals(new int[]{1, 0}, twoSum(new int[]{2, 7, 11, 15}, 9));
        Assertions.assertArrayEquals(new int[]{2, 1}, twoSum(new int[]{3, 2, 4}, 6));
    }

    @Test
    public void plusOneTest() {
        Assertions.assertArrayEquals(new int[]{1, 0, 0}, plusOne(new int[]{9, 9}));
        Assertions.assertArrayEquals(new int[]{1, 0, 0}, plusOne1(new int[]{9, 9}));
    }

    @Test
    public void intersectTest() {
        Assertions.assertArrayEquals(new int[]{1, 2}, intersect(new int[]{1, 2}, new int[]{1, 2, 2, 1}));
        Assertions.assertArrayEquals(new int[]{1, 2}, intersect(new int[]{1, 2, 2, 1}, new int[]{1, 2}));
        Assertions.assertArrayEquals(new int[]{2}, intersect(new int[]{1, 2, 2, 1}, new int[]{2}));
        Assertions.assertArrayEquals(new int[]{2, 2}, intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Assertions.assertArrayEquals(new int[]{4, 9}, intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    @Test
    public void removeDuplicatesTest() {
        Assertions.assertEquals(5, removeDuplicates1(new int[]{1, 2, 2, 3, 4, 4, 5}));
        Assertions.assertEquals(5, removeDuplicates2(new int[]{1, 2, 2, 3, 4, 4, 5}));
        Assertions.assertEquals(5, removeDuplicates3(new int[]{1, 1, 1, 2, 2, 3}));
        Assertions.assertEquals(5, removeDuplicates4(new int[]{1, 2, 2, 3, 4, 4, 5}));
        Assertions.assertEquals("abcde", removeDuplicates5("abbbcdcce"));
    }

    @Test
    public void maxProfitTest() {
        Assertions.assertEquals(5, maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        Assertions.assertEquals(7, maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    public void rotateTest() {
        Assertions.assertArrayEquals(new int[]{4, 5, 1, 2, 3}, rotate1(new int[]{1, 2, 3, 4, 5}, 2));
        Assertions.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
    }

    @Test
    public void longestCommonPrefixTest() {
        Assertions.assertEquals("", longestCommonPrefix(new String[]{"reflower", "flow", "flight"}));
        Assertions.assertEquals("", longestCommonPrefix1(new String[]{"dog", "racecar", "car"}));
        Assertions.assertEquals("fl", longestCommonPrefix1(new String[]{"flower", "flow", "flight"}));
        Assertions.assertEquals("flower", longestCommonPrefix1(new String[]{"flower", "flower", "flower", "flower"}));
    }

    @Test
    public void isValidTest() {
        Assertions.assertTrue(isValid(")(){}"));
    }

    @Test
    public void isSubsequenceTest() {
        Assertions.assertTrue(isSubsequence("abc", "ahbgdc"));
        Assertions.assertTrue(isSubsequence("aaaaaa", "bbaaaa"));
        Assertions.assertTrue(isSubsequence("b", "c"));
        Assertions.assertTrue(isSubsequence("ab", "baab"));
    }

    @Test
    public void isIsomorphicTest() {
        Assertions.assertTrue(isIsomorphic("egg", "add"));
        Assertions.assertTrue(isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    @Test
    public void wordPatternTest() {
        Assertions.assertTrue(wordPattern("abba", "dog cat cat dog"));
        Assertions.assertFalse(wordPattern("abba", "dog cat cat fish"));
    }

    @Test
    public void summaryRangesTest() {
        Assertions.assertIterableEquals(Arrays.asList("0", "2->4", "6", "8->9"),
                summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    @Test
    public void containsNearbyDuplicateTest() {
        Assertions.assertTrue(containsNearbyDuplicate(new int[]{0, 1, 2, 3, 4, 0, 0, 7, 8, 9, 10, 11, 12, 0}, 2));
        Assertions.assertTrue(containsNearbyDuplicate1(new int[]{0, 1, 2, 3, 4, 0, 0, 7, 8, 9, 10, 11, 12, 0}, 2));
    }

    @Test
    public void isHappyTest() {
        Assertions.assertTrue(isHappy(19));
    }

    @Test
    public void canJumpTest() {
        Assertions.assertTrue(canJump(new int[]{2, 3, 1, 1, 4}));
        Assertions.assertFalse(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
