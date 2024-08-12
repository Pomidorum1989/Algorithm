package org.dorum;

import org.dorum.algo.LeetCode;
import org.dorum.utils.MapToFileAppender;
import org.dorum.utils.MethodInfoRecorder;

import java.util.List;
import java.util.Map;

public class LeetCodeTest {
    public static void main(String[] args) {
        Map<String, List<String>> map = MethodInfoRecorder.recordMethodInfo(LeetCode.class);
        MapToFileAppender.appendAfterStatement(map, "README.md", "## LeetCode Method References");

//        compress(new char[]{'a','a','b','b','c','c','c'});
//        compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'});
//        compress(new char[]{'a'});
//
//        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
//        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
//
//        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
//
//        System.out.println(longestCommonPart(new String[]{"flower", "flow", "flight"}));
//
//        System.out.println(strStr("a", "a"));
//        System.out.println(strStr1("a", "a"));
//
//        System.out.println(myAtoi("00000-42a1234"));
//        System.out.println(myAtoi("1"));
//        System.out.println(myAtoi("-"));
//        System.out.println(myAtoi(""));
//        System.out.println(myAtoi(".1"));
//        System.out.println(myAtoi("3.14159"));
//        System.out.println(myAtoi("+-12"));
//        System.out.println(myAtoi("-+12"));
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("-42"));
//        System.out.println(myAtoi("      -42"));
//        System.out.println(myAtoi("      42"));
//        System.out.println(myAtoi("+42"));
//
//        System.out.println(isPalindrome1("AB$BA$$"));
//
//        System.out.println(isAnagram1("ac", "bb"));
//        System.out.println(isAnagram1("a", "ab"));
//        System.out.println(isAnagram1("anagram", "nagaram"));
//        System.out.println(isAnagram1("rat", "car"));
//
//        System.out.println(isAnagram3("anagram", "nagaram"));
//        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome2("ab_a"));
//
//        System.out.println(firstUniqueChar("leetcode"));
//        System.out.println(firstUniqChar1("leetcode"));
//        System.out.println(firstUniqueChar("aadadaad"));
//        System.out.println(firstUniqChar1("aadadaad"));
//
//        System.out.println(reverse1(1234));
//        System.out.println(reverse1(-1234));
//        System.out.println(reverse1(12345));
//
//        moveZeroes(new int[]{0, 1, 0, 3, 12});
//        moveZeroes(new int[]{0, 0, 1});
//
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
//        System.out.println(Arrays.toString(plusOne1(new int[]{9, 9})));
//
//        System.out.println(Arrays.toString(intersect(new int[]{1, 2}, new int[]{1, 2, 2, 1})));
//        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{1, 2})));
//        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2})));
//        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
//        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
//
//        System.out.println(removeDuplicates1(new int[]{1, 2, 2, 3, 4, 4, 5}));
//        System.out.println(removeDuplicates2(new int[]{1, 2, 2, 3, 4, 4, 5}));
//        System.out.println(removeDuplicates3(new int[]{1, 1, 1, 2, 2, 3}));
//        System.out.println(removeDuplicates4(new int[]{1, 2, 2, 3, 4, 4, 5}));
//        System.out.println(removeDuplicates5("abbbcdcce"));
//
//        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
//
//        rotate1(new int[]{1, 2, 3, 4, 5}, 2);
//        rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
//
//        reverse(new int[]{1, 2, 3, 4, 5});
//
//        System.out.println(longestCommonPrefix(new String[]{"reflower", "flow", "flight"}));
//        System.out.println(longestCommonPrefix1(new String[]{"dog", "racecar", "car"}));
//        System.out.println(longestCommonPrefix1(new String[]{"flower","flow","flight"}));
//        System.out.println(longestCommonPrefix1(new String[]{"flower", "flower", "flower", "flower"}));
//
//        System.out.println(isValid(")(){}"));
//
//        System.out.println(isSubsequence("abc", "ahbgdc"));
//        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
//        System.out.println(isSubsequence("b", "c"));
//        System.out.println(isSubsequence("ab", "baab"));
//
//        System.out.println(isIsomorphic("egg", "add"));
//        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
//
//        System.out.println(wordPattern("abba", "dog cat cat dog"));
//        System.out.println(wordPattern("abba", "dog cat cat fish"));
//
//        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
//
//        System.out.println(containsNearbyDuplicate1(new int[]{0, 1, 2, 3, 4, 0, 0, 7, 8, 9, 10, 11, 12, 0}, 2));
//
//        System.out.println(isHappy(19));
    }
}
