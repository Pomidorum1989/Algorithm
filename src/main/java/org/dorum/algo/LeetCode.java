package org.dorum.algo;

import org.dorum.utils.RecordMethodInfo;

import java.math.BigDecimal;
import java.util.*;

public class LeetCode {

    private static final String LEET_CODE_LINK = "https://leetcode.com/problems/";

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/">maxProfit</a>
     * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">maxProfit</a>
     */
    @RecordMethodInfo()
    public static int maxProfit(int[] prices) {
        int finalProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > finalProfit) {
                    finalProfit = profit;
                }
            }
        }
        return finalProfit;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/">maxProfit1</a>
     * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">maxProfit1</a>
     */
    @RecordMethodInfo()
    public static int maxProfit1(int[] prices) {
        int profit = Integer.MIN_VALUE;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }
            profit = Math.max(profit, prices[i] - buyPrice);
        }
        return profit;
    }

    /**
     * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">maxProfit2</a>
     */
    @RecordMethodInfo()
    public static int maxProfit2(int[] prices) {
        int profit = 0, low = 0, high = 1;
        while (high < prices.length) {
            if (prices[low] < prices[high]) {
                profit = profit + prices[high] - prices[low];
            }
            high++;
            low++;
        }
        return profit;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/">rotate</a>
     */
    @RecordMethodInfo()
    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[0];
                nums[0] = nums[j];
                nums[j] = temp;
            }
        }
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/">rotate1</a>
     */
    @RecordMethodInfo()
    public static void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse1(nums, 0, nums.length - 1);
        reverse1(nums, 0, k - 1);
        reverse1(nums, k, nums.length - 1);
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/">rotate2</a>
     */
    @RecordMethodInfo()
    public static void rotate2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[0];
                nums[0] = nums[j];
                nums[j] = temp;
            }
        }
    }

    private static void reverse1(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/">containsDuplicate</a>
     */
    @RecordMethodInfo()
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/">containsDuplicate1</a>
     */
    @RecordMethodInfo()
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/">singleNumber</a>
     */
    @RecordMethodInfo()
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.stream().iterator().next();
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/">intersect</a>
     */
    @RecordMethodInfo()
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] buffer = new int[nums1.length];
        int k = 0, first = 0, second = 0;
        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] < nums2[second]) {
                first++;
            } else if (nums1[first] > nums2[second]) {
                second++;
            } else if (nums1[first] == nums2[second]) {
                buffer[k] = nums1[first];
                first++;
                second++;
                k++;
            }
        }
        int[] result = new int[k];
        System.arraycopy(buffer, 0, result, 0, result.length);
        return result;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/">plusOne</a>
     */
    @RecordMethodInfo()
    public static int[] plusOne(int[] digits) {
        StringBuilder input = new StringBuilder();
        for (int digit : digits) {
            input.append(digit);
        }
        BigDecimal decimal = new BigDecimal(input.toString());
        input = new StringBuilder(String.valueOf(decimal.add(BigDecimal.ONE)));
        int[] result = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            result[i] = Integer.parseInt(String.valueOf(input.toString().charAt(i)));
        }
        return result;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/">plusOne1</a>
     */
    @RecordMethodInfo()
    public static int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/">twoSum</a>
     */
    @RecordMethodInfo()
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            map.put(target - nums[j], j);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                return new int[]{map.get(nums[i]), i};
            }
        }
        return null;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/">moveZeroes</a>
     */
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int k = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                for (int j = i; j > k; j--) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
                k++;
            }
            i++;
        }
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/">reverseString</a>
     */
    @RecordMethodInfo()
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/">reverse</a>
     */
    @RecordMethodInfo()
    public static int reverse(int x) {
        char[] s = String.valueOf(x).replace("-", "").toCharArray();
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        StringBuilder result = new StringBuilder();
        for (char c : s) {
            result.append(c);
        }
        int digitResult = 0;
        try {
            digitResult = (x > 0 ? Integer.parseInt(result.toString()) : Integer.parseInt("-" + result));
//            digitResult = (int) (x > 0 ? Long.parseLong(result.toString()) : Long.parseLong("-" + result));
        } catch (NumberFormatException ignored) {

        }
        return digitResult;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/">reverse1</a>
     */
    @RecordMethodInfo()
    public static int reverse1(int x) {
        long finalNum = 0;
        while (x != 0) {
            int lastDig = x % 10;
            finalNum += lastDig;
            finalNum = finalNum * 10;
            x = x / 10;
        }
        finalNum = finalNum / 10;
        if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) finalNum;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/">firstUniqueChar</a>
     */
    @RecordMethodInfo()
    public static int firstUniqueChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/">firstUniqueChar1</a>
     */
    @RecordMethodInfo()
    public static int firstUniqueChar1(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/">isAnagram</a>
     */
    @RecordMethodInfo()
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/">isAnagram1</a>
     */
    @RecordMethodInfo()
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] alphabet = new char[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for (char c : alphabet) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/valid-anagram/">isAnagram3</a>
     */
    @RecordMethodInfo()
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        for (int i = 0; i < array1.length; i++) {
            if (!map1.containsKey(array1[i])) {
                map1.put(array1[i], 1);
            } else {
                map1.put(array1[i], map1.get(array1[i]) + 1);
            }
            if (!map2.containsKey(array2[i])) {
                map2.put(array2[i], 1);
            } else {
                map2.put(array2[i], map2.get(array2[i]) + 1);
            }
        }
        return map1.equals(map2);
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/">isPalindrome</a>
     */
    @RecordMethodInfo()
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                input.append(s.charAt(i));
            }
        }
        StringBuilder output = new StringBuilder(input);
        input.reverse();
        return input.compareTo(output) == 0;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/">isPalindrome1</a>
     */
    @RecordMethodInfo()
    public static boolean isPalindrome1(String s) {
        if (s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            boolean flagStart = (s.charAt(start) >= 'a' && s.charAt(start) <= 'z') || (s.charAt(start) >= '0' && s.charAt(start) <= '9');
            boolean flagEnd = (s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= '0' && s.charAt(end) <= '9');
            if (!flagStart) {
                start++;
            }
            if (!flagEnd) {
                end--;
            }
            if (flagStart && flagEnd) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/">isPalindrome2</a>
     */
    @RecordMethodInfo()
    public static boolean isPalindrome2(String s) {
        String s1 = s.toLowerCase().replaceAll("[^\\w\\d]", "").replaceAll("_", "");
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s1.charAt(s1.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/">myAtoi</a>
     */
    @RecordMethodInfo()
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 1 && !Character.isDigit(s.charAt(0))) {
            return 0;
        }
        if (s.contains(".")) {
            s = s.substring(0, s.indexOf("."));
        }
        if (s.isEmpty() || Character.isLetter(s.charAt(0))) {
            return 0;
        } else if (s.startsWith("0")) {
            return 0;
        }
        long result;
        if (s.startsWith("-") && Character.isDigit(s.charAt(s.indexOf("-") + 1))) {
            result = -Long.parseLong(s.substring(1));
        } else if ((s.startsWith("+") && Character.isDigit(s.charAt(s.indexOf("+") + 1))) || Character.isDigit(s.charAt(0))) {
            result = Long.parseLong(s.replaceAll("[^0-9-]", ""));
        } else {
            return 0;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/">strStr</a>
     */
    @RecordMethodInfo()
    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/">strStr1</a>
     */
    @RecordMethodInfo()
    public static int strStr1(String haystack, String needle) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = i; j < needle.length() + i; j++) {
                result.append(haystack.charAt(j));
            }
            if (result.toString().equals(needle)) {
                return i;
            } else {
                result = new StringBuilder();
            }
        }
        return -1;
    }

    /**
     * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/">longestCommonPart</a>
     */
    @RecordMethodInfo()
    public static String longestCommonPart(String[] strs) {
        int length = strs[0].length();
        while (length != 0) {
            boolean flag = true;
            String subString = "";
            for (String str : strs) {
                subString = strs[0].substring(0, length);
                if (!str.contains(subString)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return subString;
            }
            length--;
        }
        return "";
    }

    /**
     * <a href="https://leetcode.com/problems/longest-common-prefix/">longestCommonPrefix</a>
     */
    @RecordMethodInfo()
    public static String longestCommonPrefix(String[] strs) {
        int length = strs[0].length();
        while (length != 0) {
            boolean flag = true;
            String subString = "";
            for (String str : strs) {
                subString = strs[0].substring(0, length);
                if (!str.startsWith(subString)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return subString;
            }
            length--;
        }
        return "";
    }

    /**
     * <a href="https://leetcode.com/problems/longest-common-prefix/">longestCommonPrefix1</a>
     */
    @RecordMethodInfo()
    public static String longestCommonPrefix1(String[] strs) {
        if (strs[0].isEmpty()) {
            return "";
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = commonPrefix.length(); j > 0; j--) {
                if (strs[i].startsWith(commonPrefix)) {
                    break;
                }
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
            if (commonPrefix.isEmpty()) {
                return "";
            }
        }
        return commonPrefix;
    }

    /**
     * <a href="https://leetcode.com/problems/merge-sorted-array/">merge</a>
     */
    @RecordMethodInfo()
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[nums1.length - i - 1] = nums2[nums2.length - i - 1];
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[i] < nums1[j]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[i];
                    nums1[i] = temp;
                }
            }
        }
    }

    /**
     * <a href="https://leetcode.com/problems/remove-element/">removeElement</a>
     */
    @RecordMethodInfo()
    public static int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">removeDuplicates</a>
     */
    @RecordMethodInfo()
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int maxValue = nums[length - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.contains(nums[i])) {
                for (int j = i; j < length - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                i -= 1;
                if (nums[i] == maxValue) {
                    break;
                }
            } else {
                set.add(nums[i]);
            }
        }
        return set.size();
    }

    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">removeDuplicates1</a>
     */
    @RecordMethodInfo()
    public static int removeDuplicates1(int[] nums) {
        Set<Integer> unique = new LinkedHashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        int index = 0;
        for (Integer uniqueElement : unique) {
            nums[index] = uniqueElement;
            index++;
        }
        return index;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">removeDuplicates2</a>
     */
    @RecordMethodInfo()
    public static int removeDuplicates2(int[] nums) {
        int previousPointer = 0;
        int currentPointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[previousPointer] != nums[i]) {
                nums[currentPointer] = nums[i];
                previousPointer = currentPointer;
                currentPointer++;
            }
        }
        return currentPointer;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">removeDuplicates3</a>
     */
    @RecordMethodInfo()
    public static int removeDuplicates3(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">removeDuplicates4</a>
     */
    @RecordMethodInfo()
    public static int removeDuplicates4(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/">removeDuplicates5</a>
     */
    @RecordMethodInfo()
    public static String removeDuplicates5(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int length = sb.length();
            if (length > 0 && sb.charAt(length - 1) == c) {
                sb.deleteCharAt(length - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * <a href="https://leetcode.com/problems/string-compression/">compress</a>
     */
    @RecordMethodInfo()
    public static int compress(char[] chars) {
        Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (char aChar : chars) {
            if (linkedHashMap.containsKey(aChar)) {
                linkedHashMap.put(aChar, linkedHashMap.get(aChar) + 1);
            } else {
                linkedHashMap.put(aChar, 1);
            }
        }
        int i = 0;
        for (Map.Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            chars[i] = key;
            if (value == 1) {
                i++;
            } else {
                if (chars.length > 1) {
                    chars[i + 1] = value.toString().toCharArray()[0];
                    if (value.toString().toCharArray().length > 1) {
                        chars[i + 2] = value.toString().toCharArray()[1];
                        i++;
                    }
                    i += 2;
                }
            }
        }
        if (linkedHashMap.size() == 1) {
            return 1;
        }
        return linkedHashMap.size() * 2;
    }

    /**
     * <a href="https://leetcode.com/problems/ugly-number/">isUgly</a>
     */
    @RecordMethodInfo()
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    /**
     * <a href="https://leetcode.com/problems/length-of-last-word/">lengthOfLastWord</a>
     */
    @RecordMethodInfo()
    public static int lengthOfLastWord(String s) {
        String[] array = s.split("\\s");
        return array[array.length - 1].length();
    }

    /**
     * <a href="https://leetcode.com/problems/valid-parentheses/">isValid</a>
     */
    @RecordMethodInfo()
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(
                '(', ')',
                '{', '}',
                '[', ']');
        if (s.isEmpty()) {
            return true;
        }
        char[] array = s.toCharArray();
        for (char c : array) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.containsValue(c)) {
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * <a href="https://leetcode.com/problems/is-subsequence/">isSubsequence</a>
     */
    public static boolean isSubsequence(String s, String t) {
        int sp = 0, tp = 0;
        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }
        return sp == s.length();
    }

    /**
     * <a href="https://leetcode.com/problems/ransom-note/">canConstruct</a>
     */
    @RecordMethodInfo()
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (magazineMap.containsKey(c)) {
                magazineMap.put(c, magazineMap.get(c) + 1);
            } else {
                magazineMap.put(c, 1);
            }
        }
        Map<Character, Integer> noteMap = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (noteMap.containsKey(c)) {
                noteMap.put(c, noteMap.get(c) + 1);
            } else {
                noteMap.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : noteMap.entrySet()) {
            Character k = entry.getKey();
            Integer v = entry.getValue();
            if (magazineMap.get(k) == null || v > magazineMap.get(k)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/isomorphic-strings/">isIsomorphic</a>
     */
    @RecordMethodInfo()
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> mapS = new LinkedHashMap<>();
        Map<Character, Integer> mapT = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1 + i);
            } else {
                mapS.put(s.charAt(i), 1 + i);
            }

            if (mapT.containsKey(t.charAt(i))) {
                mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1 + i);
            } else {
                mapT.put(t.charAt(i), 1 + i);
            }
        }
        Iterator<Map.Entry<Character, Integer>> iterator1 = mapS.entrySet().iterator();
        Iterator<Map.Entry<Character, Integer>> iterator2 = mapT.entrySet().iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (!iterator1.next().getValue().equals(iterator2.next().getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/word-pattern/">wordPattern</a>
     */
    @RecordMethodInfo()
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, Integer> mapPattern = new LinkedHashMap<>();
        Map<String, Integer> mapS = new LinkedHashMap<>();
        String[] arrayString = s.split("\\s");
        if (arrayString.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < arrayString.length; i++) {
            if (mapS.containsKey(arrayString[i])) {
                mapS.put(arrayString[i], mapS.get(arrayString[i]) + 1 + i);
            } else {
                mapS.put(arrayString[i], 1 + i);
            }

            if (mapPattern.containsKey(pattern.charAt(i))) {
                mapPattern.put(pattern.charAt(i), mapPattern.get(pattern.charAt(i)) + 1 + i);
            } else {
                mapPattern.put(pattern.charAt(i), 1 + i);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator1 = mapS.entrySet().iterator();
        Iterator<Map.Entry<Character, Integer>> iterator2 = mapPattern.entrySet().iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (!iterator1.next().getValue().equals(iterator2.next().getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/summary-ranges/">summaryRanges</a>
     */
    @RecordMethodInfo()
    public static List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        if (nums.length == 0) {
            return answer;
        }
        int firstPointer = 0;
        int secondPointer = 1;
        while (secondPointer < nums.length) {
            if (nums[secondPointer] - nums[secondPointer - 1] != 1) {
                if (nums[firstPointer] == nums[secondPointer - 1]) {
                    answer.add(String.valueOf(nums[firstPointer]));
                } else {
                    answer.add(nums[firstPointer] + "->" + nums[secondPointer - 1]);
                }
                firstPointer = secondPointer;
            }
            secondPointer++;
        }
        if (nums[firstPointer] == nums[secondPointer - 1]) {
            answer.add(String.valueOf(nums[firstPointer]));
        } else {
            answer.add(nums[firstPointer] + "->" + nums[secondPointer - 1]);
        }
        return answer;
    }

    /**
     * <a href="https://leetcode.com/problems/contains-duplicate-ii">containsNearbyDuplicate</a>
     */
    @RecordMethodInfo()
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (j != i && nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <a href="https://leetcode.com/problems/contains-duplicate-ii">containsNearbyDuplicate1</a>
     */
    @RecordMethodInfo(link = LEET_CODE_LINK + "contains-duplicate-ii/")
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> uniqueValues = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!uniqueValues.add(nums[i])) {
                if ((Math.abs(i - map.get(nums[i])) <= k)) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * <a href="{@link LeetCode#LEET_CODE_LINK}happy-number/">isHappy</a>
     */
    @RecordMethodInfo(link = LEET_CODE_LINK + "happy-number/")
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        String number = String.valueOf(n);
        while (true) {
            int sum = (int) Math.pow(Integer.parseInt(String.valueOf(number.charAt(0))), 2);
            if (Integer.parseInt(number) > 10) {
                for (int i = 1; i < number.length(); i++) {
                    sum = (int) (sum + Math.pow(Integer.parseInt(String.valueOf(number.charAt(i))), 2));
                }
            }
            number = String.valueOf(sum);
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
        }
    }
}
