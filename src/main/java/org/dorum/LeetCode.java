package org.dorum;

import java.math.BigDecimal;
import java.util.*;

public class LeetCode {

    public static void main(String[] args) {
        fizzBuzz(15);
        fizzBuzz1(15);

//        rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
//        System.out.println(removeDuplicates3(new int[]{1, 1, 1, 1, 2, 2, 3}));

//        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
//        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

//        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);


//        System.out.println(longestCommonPrefix(new String[]{"reflower", "flow", "flight"}));
//        System.out.println(longestCommonPart(new String[]{"flower", "flow", "flight"}));

//        System.out.println(strStr1("a", "a"));

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

//        System.out.println(isPalindrome1("AB$BA$$"));

//        System.out.println(isAnagram1("ac", "bb"));
//        System.out.println(isAnagram1("a", "ab"));
//        System.out.println(isAnagram1("anagram", "nagaram"));
//        System.out.println(isAnagram1("rat", "car"));

//        System.out.println(firstUniqChar("leetcode"));
//        System.out.println(firstUniqChar1("leetcode"));
//        System.out.println(firstUniqChar("aadadaad"));
//        System.out.println(firstUniqChar1("aadadaad"));

//        System.out.println(reverse1(1234));
//        System.out.println(reverse1(-1234));

//        moveZeroes(new int[]{0, 1, 0, 3, 12});
//        moveZeroes(new int[]{0, 0, 1});

//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
//        System.out.println(Arrays.toString(plusOne1(new int[]{9, 9})));

//        System.out.println(Arrays.toString(intersect(new int[]{1, 2}, new int[]{1, 2, 2, 1})));
//        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{1, 2})));
//        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2})));
//        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
//        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));


//        System.out.println(removeDuplicates(new int[]{1, 2, 2, 3, 4, 4, 5}));
//        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
//        System.out.println(removeDuplicates(new int[]{1, 1}));
//        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        rotate1(new int[]{1, 2, 3, 4, 5}, 2);
//        reverse(new int[]{1, 2, 3, 4, 5});
//        reverse1(new int[]{1, 2, 3, 4, 5});
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
    public static int removeDuplicates(int[] nums) {
        System.out.println("Input: " + Arrays.toString(nums));
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
                System.out.println(Arrays.toString(nums));
            } else {
                set.add(nums[i]);
            }
        }
        System.out.println("Output: " + Arrays.toString(nums));
        return set.size();
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
    public static int maxProfit(int[] prices) {
        int profit = 0, currentProfit;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                currentProfit = prices[i + 1] - prices[i];
                System.out.println("Current profit: " + currentProfit);
                profit = profit + currentProfit;
            }
        }
        System.out.println("Profit: " + profit);
        return profit;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
    public static void rotate(int[] nums, int k) {
        System.out.println("Input array: " + Arrays.toString(nums));
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[0];
                nums[0] = nums[j];
                nums[j] = temp;
            }
        }
        System.out.println("Output array: " + Arrays.toString(nums));
    }

    public static void rotate1(int[] nums, int k) {
        System.out.println("Input array: " + Arrays.toString(nums));
        k %= nums.length;
        reverse1(nums, 0, nums.length - 1);
        reverse1(nums, 0, k - 1);
        reverse1(nums, k, nums.length - 1);
        System.out.println("Output array: " + Arrays.toString(nums));
    }

    public static void reverse(int[] nums) {
        System.out.println("Input array: " + Arrays.toString(nums));
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        System.out.println("Output array: " + Arrays.toString(nums));
    }

    public static void reverse1(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
    public static int[] intersect(int[] nums1, int[] nums2) {
        System.out.println("Input array: " + Arrays.toString(nums1));
        System.out.println("Input array: " + Arrays.toString(nums2));
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
    public static int[] twoSum(int[] nums, int target) {
        System.out.println("Input array: " + Arrays.toString(nums));
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            map.put(target - nums[j], j);
        }
        System.out.println(map);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
        }
        return null;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
    public static void moveZeroes(int[] nums) {
        System.out.println("Input array: " + Arrays.toString(nums));
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
        System.out.println("Output array: " + Arrays.toString(nums));
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
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
        if (x < 0) {
            return (int) (-1 * finalNum);
        }
        return (int) finalNum;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
    public static int firstUniqChar(String s) {
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
    public static int firstUniqChar1(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
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
        System.out.println(input);
        System.out.println(output);
        return input.compareTo(output) == 0;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
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

    //https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

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
        System.out.println(Arrays.toString(nums1));
    }

    //https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
    public static int removeElement(int[] nums, int val) {
        System.out.println(Arrays.toString(nums));
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter] = nums[i];
                counter++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return counter;
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
    public static int removeDuplicates1(int[] nums) {
        System.out.println(Arrays.toString(nums));
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (int num : nums) {
            duplicates.add(num);
        }
        int index = 0;
        for (Integer duplicate : duplicates) {
            nums[index] = duplicate;
            index++;
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }

    public static void removeDuplicates2(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int previousPointer = 0;
        int currentPointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[previousPointer] != nums[i]) {
                nums[currentPointer] = nums[i];
                previousPointer = currentPointer;
                currentPointer++;
            }
            System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(nums));
    }

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

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
    public static int removeDuplicates3(int[] nums) {
        System.out.println(Arrays.toString(nums));

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return j;
    }

    public static void rotate2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[0];
                nums[0] = nums[j];
                nums[j] = temp;
            }
        }
        System.out.println(k % nums.length);
        System.out.println(Arrays.toString(nums));
    }

    //https://leetcode.com/problems/fizz-buzz/description/
    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean isThree = i % 3 == 0;
            boolean isFive = i % 5 == 0;
            boolean isThreeFive = isThree && isFive;

            if (isThreeFive) {
                answer.add("FizzBuzz");
            } else if (isThree) {
                answer.add("Fizz");
            } else if (isFive) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static List<String> fizzBuzz1(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean isThree = i % 3 == 0;
            boolean isFive = i % 5 == 0;

            switch ((isThree ? 1 : 0) + (isFive ? 2 : 0)) {
                case 3:
                    answer.add("FizzBuzz");
                    break;
                case 1:
                    answer.add("Fizz");
                    break;
                case 2:
                    answer.add("Buzz");
                    break;
                default:
                    answer.add(String.valueOf(i));
            }
        }
        System.out.println(answer);
        return answer;
    }
}
