package org.dorum.algo;

import org.dorum.utils.RecordMethodInfo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Codility {

    private static final String CODILITY_LINK = "https://app.codility.com/programmers/lessons/";

    @RecordMethodInfo()
    public static boolean palindromeCheck(String text) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            reversedString.append(text.charAt(text.length() - i - 1));
        }
        return reversedString.toString().equals(text);
    }

    @RecordMethodInfo()
    public static boolean palindromeCheck1(String text) {
        StringBuilder reversedString = new StringBuilder(text).reverse();
        return reversedString.toString().equals(text);
    }

    @RecordMethodInfo()
    public static boolean palindromeCheck2(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left <= right) {
            if (text.charAt(left) != text.charAt(right)) {
                System.out.println(text.charAt(left) + " not equal to " + text.charAt(right));
                return false;
            }
            left++;
            right--;
        }
        System.out.println("Left index: " + left);
        System.out.println("Right index: " + right);
        System.out.println("----------------------");
        System.out.println("Left letter: " + text.charAt(left));
        System.out.println("Right letter: " + text.charAt(right));
        return true;
    }

    @RecordMethodInfo()
    public static boolean palindromeCheck3(String text, int indexStart) {
        System.out.println(text);
        int indexEnd = text.length() - 1 - indexStart;
        System.out.println(text.charAt(indexStart) + "-" + text.charAt(indexEnd));
        if (indexStart >= indexEnd) {
            return true;
        } else {
            return text.charAt(indexStart) == text.charAt(indexEnd) && palindromeCheck3(text, indexStart + 1);
        }
    }

    @RecordMethodInfo()
    public static void findMinimumValueIndex(int[] array) {
        int minimumValueIndex = 0;
        for (int k : array) {
            for (int i = 0; i < array.length; i++) {
                if (k < array[i]) {
                    System.out.println(k + "<" + array[i]);
                    minimumValueIndex = i;
                }
            }
        }
        System.out.println("Minimum value index: " + minimumValueIndex);
        System.out.println("Minimum value : " + array[minimumValueIndex]);
    }

    public static void bubbleSort(int[] array) {
        int actionCounter = 0;
        System.out.println("Input array: " + Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[i] < array[j]) {
                    actionCounter++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("Actions: " + actionCounter);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}1-iterations/">binaryGap</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "1-iterations/")
    public static int binaryGap(int n) {
        System.out.println("Input: " + n);
        if (n % 2 == 0) {
            return 0;
        }
        int counter = 0;
        int temp = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                counter++;
            } else if (counter > temp) {
                temp = counter;
                counter = 0;
            }
            n = n / 2;
        }
        return temp;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}2-arrays/">rotateArray</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "2-arrays/")
    public static int[] rotateArray(int[] A, int K) {
        System.out.println("Input array: " + Arrays.toString(A));
        System.out.println("Input: " + K);
        int temp;
        for (int j = 0; j < K; j++) {
            for (int i = 1; i <= A.length - 1; i++) {
                temp = A[0];
                A[0] = A[i];
                A[i] = temp;
                System.out.println("Temporary array state on iteration " + i + ": " + Arrays.toString(A));
            }
        }
        System.out.println("Output array: " + Arrays.toString(A));
        System.out.println("___________________________________");
        return A;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}2-arrays/">rotateArray</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "2-arrays/")
    public static int findExtraElement(int[] A) {
        System.out.println("Input array: " + Arrays.toString(A));
        HashSet<Integer> result = new HashSet<>();
        for (int j : A) {
            if (result.contains(j)) {
                result.remove(j);
            } else {
                result.add(j);
            }
        }
        return result.iterator().next();
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}3-time_complexity/">frogJump</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "3-time_complexity")
    public static int frogJump(int start, int end, int jump) {
        int distance = end - start;
        if (distance <= 0) {
            return 0;
        }
        if (distance % jump == 0) {
            return distance / jump;
        } else {
            int jumps = distance / jump;
            return jumps + 1;
        }
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}3-time_complexity/">permMissingElem</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "3-time_complexity")
    public static int permMissingElem(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        int maximumNumber = A.length + 1;
        int totalSum = (maximumNumber * (maximumNumber + 1)) / 2;
        System.out.println("Total sum: " + totalSum);
        int partialSum = 0;
        for (int j : A) {
            partialSum += j;
        }
        System.out.println("Partial sum: " + partialSum);
        return totalSum - partialSum;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}3-time_complexity/">tapeEquilibrium</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "3-time_complexity")
    public static int tapeEquilibrium(int[] A) {
        int totalSum = 0, result = Integer.MAX_VALUE;
        for (int element : A) {
            totalSum += element;
        }
        int leftSum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            int rightSum = totalSum - leftSum;
            int diff = Math.abs(leftSum - rightSum);
            if (diff < result) {
                result = diff;
            }
        }
        return result;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}4-counting_elements/">frogRiverOne</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "4-counting_elements/")
    public static int frogRiverOne(int X, int[] A) {
        Set<Integer> steps = new HashSet<>();
        for (int i = 1; i <= X; i++) {
            steps.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            if (steps.remove(A[i])) {
                if (steps.isEmpty()) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}4-counting_elements/">permCheck</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "4-counting_elements/")
    public static int permCheck(int[] A) {
        int expectedSum = (A.length * (A.length + 1)) / 2;
        int currentSum = 0;
        for (int j : A) {
            currentSum = currentSum + j;
        }
        return currentSum == expectedSum ? 1 : 0;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}4-counting_elements/">permCheck1</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "4-counting_elements/")
    public static int permCheck1(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= A.length; i++) {
            set.add(i);
        }
        for (int j : A) {
            if (set.remove(j)) {
                if (set.isEmpty()) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}4-counting_elements/">missingInteger</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "4-counting_elements/")
    public static int missingInteger(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= A.length + 1; i++) {
            set.add(i);
        }
        System.out.println("Set before: " + set);
        for (int j : A) {
            set.remove(j);
        }
        System.out.println("Set after: " + set);
        return set.iterator().next();
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}5-prefix_sums/">passingCars</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "5-prefix_sum/")
    public static int passingCars(int[] A) {
        System.out.println("Input array:" + Arrays.toString(A));
        int carsTravellingEast = 0;
        long passedCars = 0;
        for (int j : A) {
            if (j == 0) {
                carsTravellingEast++;
            } else {
                passedCars += carsTravellingEast;
            }
            if (passedCars > 1000000) {
                return -1;
            }
        }
        return (int) passedCars;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}5-prefix_sums/">passingCars1</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "5-prefix_sum/")
    public static int passingCars1(int[] A) {
        System.out.println("Input array:" + Arrays.toString(A));
        int sum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == 0 && A[j] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
