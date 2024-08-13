package org.dorum.algo;

import lombok.Getter;
import lombok.Setter;
import org.dorum.utils.RecordMethodInfo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedIn {

    public static final String LINKEDIN_LINK = "https://www.linkedin.com/learning/nail-your-java-interview-2/";

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static void countWordsInSentence(String input) {
        String[] exclude = {",", "\\.", " a ", " the ", " to ", " of ", " are ", " is "};
        for (String string : exclude) {
            input = input.replaceAll(string, " ");
        }
        String[] s = input.toLowerCase().trim().split(" ");
        List<String> sentenceWords = Arrays.stream(s).filter(word -> !word.isEmpty()).collect(Collectors.toList());
        System.out.println("Sentence words: " + sentenceWords);
        Map<String, Integer> wordCounter = new LinkedHashMap<>();
        sentenceWords.forEach(word -> wordCounter.put(word, 0));
        System.out.println("Initial map:" + wordCounter);
        int counter = 0;
        for (String key : wordCounter.keySet()) {
            for (String word : sentenceWords) {
                if (key.equals(word)) {
                    counter++;
                }
            }
            wordCounter.put(key, counter);
            counter = 0;
        }
        System.out.println("Modified map:" + wordCounter);

        int maxValue = 0;
        String maxWord = "";

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCounter.entrySet());
        Collections.reverse(entries);
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() >= maxValue) {
                maxValue = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        System.out.println("Max word: " + maxWord);
        System.out.println("_____________________________________________________________________________________");
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static boolean findParentheses1(String input) {
        Map<Character, Character> parentheses = Map.of(')', '(', '>', '<', ']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (parentheses.containsValue(current)) {
                stack.push(current);
                continue;
            }
            if (parentheses.containsKey(current) && stack.isEmpty()) {
                return false;
            }
            if (parentheses.containsKey(current) && parentheses.get(current) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static boolean findParentheses(String input) {
        System.out.println("Input string: " + input);
        String[] openBrackets = new String[]{"(", "<", "["};
        String[] closeBrackets = new String[]{")", ">", "]"};
        System.out.println("______________________________________________________________________________________");
        for (int i = 0; i < openBrackets.length; i++) {
            int openBracketIndex = input.indexOf(openBrackets[i]);
            System.out.println("First index: " + openBracketIndex);
            int closeBracketIndex = input.indexOf(closeBrackets[i]);
            System.out.println("Second index: " + closeBracketIndex);
            if (openBracketIndex > closeBracketIndex) {
                return false;
            }
            if (openBracketIndex == -1 && closeBracketIndex >= 0) {
                return false;
            }
        }
        System.out.println("______________________________________________________________________________________");
        return true;
    }

    @Getter
    @Setter
    public static class CustomNode<D> {
        D data;
        CustomNode<D> nextNodeRef;

        CustomNode(D data) {
            this.data = data;
        }

        @Override
        public String toString() {
            if (this.nextNodeRef == null) {
                return "Data value: " + this.data;
            } else {
                return "Data value: " + this.data + " reference to the next node: " + this.nextNodeRef.getData();
            }
        }

        public static CustomNode<Integer> buildNode(int data) {
            CustomNode<Integer> node = new CustomNode<>(data);
            node.setNextNodeRef(null);
            return node;
        }

        public static void printList(CustomNode<Integer> head) {
            while (head != null) {
                System.out.println("Node data: " + head.getData());
                head = head.getNextNodeRef();
            }
        }
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static void deleteMiddleNode(CustomNode<Integer>[] array) {
        System.out.println("Input array: " + Arrays.toString(array));
        int middleNodeIndex = (array.length % 2 == 0) ? array.length / 2 : array.length / 2 + 1;
        array[middleNodeIndex] = null;
        System.out.println("Output array: " + Arrays.toString(array));
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static void maximumProductOf2Numbers(int[] array) {
        if (array.length < 2) {
            System.out.println("Less than 2 numbers in the array");
            return;
        }
        int maximumPositiveNumberOne = 0, maximumPositiveNumberTwo = 0;
        int minimumPositiveNumberOne = 0, minimumPositiveNumberTwo = 0;

        for (int j : array) {
            if (j > 0) {
                if (maximumPositiveNumberOne < j) {
                    maximumPositiveNumberTwo = maximumPositiveNumberOne;
                    maximumPositiveNumberOne = j;
                }
            } else {
                if (minimumPositiveNumberOne > j) {
                    minimumPositiveNumberTwo = minimumPositiveNumberOne;
                    minimumPositiveNumberOne = j;
                }
            }
        }
        int maximumPositiveSum = maximumPositiveNumberOne * maximumPositiveNumberTwo;
        int maximumNegativeSum = minimumPositiveNumberOne * minimumPositiveNumberTwo;

        System.out.println("----------------------------------");
        System.out.println("Positive sum: " + maximumPositiveSum);
        System.out.println("Negative sum: " + maximumNegativeSum);
        System.out.println("----------------------------------");
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static void vowelsCounter(String word) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
        String vowelsAsString = "aeiouy";
        int numberOfVowels = 0;
        int numberOfConsonants = 0;
//        for (int i = 0; i < word.length(); i++) {
//            for (char vowel : vowels) {
//                if (word.charAt(i) == vowel) {
//                    numberOfVowels++;
//                }
//            }
//        }

        for (char c : word.toCharArray()) {
            if (vowelsAsString.indexOf(c) != -1) {
                numberOfVowels++;
            } else {
                numberOfConsonants++;
            }
        }

        System.out.println("Vowels:" + numberOfVowels);
        System.out.println("Consonants:" + (word.length() - numberOfVowels));
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static boolean palindromeChecker(String word) {
        System.out.println("Input: " + word);
        String reversed = new StringBuilder(word).reverse().toString();

        boolean result = IntStream.range(0, word.length() / 2).
                allMatch(i -> word.charAt(i) == word.charAt(word.length() - i - 1));

        char[] backWardsWordCharArray = word.toCharArray();
        StringBuilder backWardsWord = new StringBuilder();
        for (int i = backWardsWordCharArray.length; i > 0; i--) {
            backWardsWord.append(backWardsWordCharArray[i - 1]);
        }
        System.out.println("Result: " + backWardsWord);
        if (backWardsWord.toString().equalsIgnoreCase(word)) {
            System.out.println(word + " is palindrome");
            return true;
        } else {
            System.out.println(word + " is NOT palindrome");
            return false;
        }
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static void compare2strings(String one, String two) {
        int res = one.compareTo(two);
        System.out.println(res);
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    System.out.println("Number '" + nums[i] + "' has pair");
                    break;
                }
            }
        }
        return result;
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static boolean containsDuplicate(int[] nums) {
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
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    private static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    break;
                }
                if (nums[i] == nums[j]) {
                    System.out.println("index i: " + i + " index j: " + j);
                    System.out.println("value i: " + nums[i] + " value j: " + nums[j]);
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
                    k++;
                    nums[i] = 101;
                }
            }
        }
        System.out.println("Initial array: " + Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println("Modified array:" + Arrays.toString(nums));
        System.out.println("Amount of duplicates: " + k);
        return k;
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    private static void swap() {
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int k = 3;

        int[] nums = new int[]{1, 2};
        int k = 2;

        int[] newArray = new int[nums.length];
        System.out.println("Initial array: " + Arrays.toString(nums));
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            }
        }

        if (nums.length > 2) {
            for (int i = 0; i < k; i++) {
                newArray[i] = nums[nums.length - k + i];
            }
            System.out.println("New array: " + Arrays.toString(newArray));

            for (int i = 0; i < nums.length - k; i++) {
                newArray[i + k] = nums[i];
                System.out.println(i + 1 + " add " + Arrays.toString(newArray));
            }
            System.arraycopy(newArray, 0, nums, 0, newArray.length);
        }
        System.out.println("Result: " + Arrays.toString(nums));
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    private static void profit() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int currentProfit;
            if (prices[i] < prices[i + 1]) {
                currentProfit = prices[i + 1] - prices[i];
                System.out.println("Current profit: " + currentProfit);
                profit = profit + currentProfit;
            }
        }
        System.out.println("Profit: " + profit);
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static String decimalToBinary(int decimal) {
        StringBuilder builder = new StringBuilder();
        while (decimal != 0) {
            if (decimal % 2 == 0) {
                builder.append(0);
            } else {
                builder.append(1);
            }
            decimal = decimal / 2;
        }
        return builder.toString();
    }

    /**
     * <a href="{@link LinkedIn#LINKEDIN_LINK}">countWordsInSentence</a>
     */
    @RecordMethodInfo(link = LINKEDIN_LINK)
    public static int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }
        return ans;
    }
}
