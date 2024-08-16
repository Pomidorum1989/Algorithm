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
    public static int findMinimumValueIndex(int[] array) {
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
        return minimumValueIndex;
    }

    @RecordMethodInfo()
    public static int findMinimumValueIndex1(int[] array) {
        int minimumValueIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                minimumValueIndex = i;
            }
        }
        System.out.println("Minimum value index: " + minimumValueIndex);
        System.out.println("Minimum value : " + array[minimumValueIndex]);
        return minimumValueIndex;
    }

    @RecordMethodInfo()
    public static int[] bubbleSort(int[] array) {
        int actionCounter = 0;
        System.out.println("Input array: " + Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    actionCounter++;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Actions: " + actionCounter);
        System.out.println("Sorted array: " + Arrays.toString(array));
        return array;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}1-iterations/binary_gap">binaryGap</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "1-iterations/binary_gap")
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
     * <a href="{@link Codility#CODILITY_LINK}2-arrays/cyclic_rotation/">rotateArray</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "2-arrays/cyclic_rotation/")
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
     * <a href="{@link Codility#CODILITY_LINK}2-arrays/odd_occurrences_in_array/">findExtraElement</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "2-arrays/odd_occurrences_in_array/")
    public static int findExtraElement(int[] a) {
        HashSet<Integer> result = new HashSet<>();
        for (int j : a) {
            if (result.contains(j)) {
                result.remove(j);
            } else {
                result.add(j);
            }
        }
        return result.iterator().next();
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}3-time_complexity/frog_jmp/">frogJump</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "3-time_complexityfrog_jmp/")
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
     * <a href="{@link Codility#CODILITY_LINK}3-time_complexity/perm_missing_elem/">permMissingElem</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "3-time_complexity/perm_missing_elem/")
    public static int permMissingElem(int[] array) {
        if (array.length == 0) {
            return 1;
        }
        int maximumNumber = array.length + 1;
        int totalSum = (maximumNumber * (maximumNumber + 1)) / 2;
        System.out.println("Total sum: " + totalSum);
        int partialSum = 0;
        for (int j : array) {
            partialSum += j;
        }
        System.out.println("Partial sum: " + partialSum);
        return totalSum - partialSum;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}3-time_complexity/tapeEquilibrium/">tape_equilibrium/</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "3-time_complexity/tape_equilibrium/")
    public static int tapeEquilibrium(int[] array) {
        int totalSum = 0, result = Integer.MAX_VALUE;
        for (int element : array) {
            totalSum += element;
        }
        int leftSum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            leftSum += array[i];
            int rightSum = totalSum - leftSum;
            int diff = Math.abs(leftSum - rightSum);
            if (diff < result) {
                result = diff;
            }
        }
        return result;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}4-counting_elements/frog_river_one/">frogRiverOne</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "4-counting_elements/frog_river_one/")
    public static int frogRiverOne(int x, int[] array) {
        Set<Integer> steps = new HashSet<>();
        for (int i = 1; i <= x; i++) {
            steps.add(i);
        }
        for (int i = 0; i < array.length; i++) {
            if (steps.remove(array[i])) {
                if (steps.isEmpty()) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}4-counting_elements/perm_check">permCheck</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "4-counting_elements/perm_check")
    public static int permCheck(int[] array) {
        int expectedSum = (array.length * (array.length + 1)) / 2;
        int currentSum = 0;
        for (int j : array) {
            currentSum = currentSum + j;
        }
        return currentSum == expectedSum ? 1 : 0;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}4-counting_elements/perm_check">permCheck1</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "4-counting_elements/perm_check")
    public static int permCheck1(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= array.length; i++) {
            set.add(i);
        }
        for (int j : array) {
            if (set.remove(j)) {
                if (set.isEmpty()) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}4-counting_elements/missing_integer/">missingInteger</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "4-counting_elements/missing_integer/")
    public static int missingInteger(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= a.length + 1; i++) {
            set.add(i);
        }
        System.out.println("Set before: " + set);
        for (int j : a) {
            set.remove(j);
        }
        System.out.println("Set after: " + set);
        return set.iterator().next();
    }

    /**
     * <a href="{@link Codility#CODILITY_LINK}5-prefix_sums/passing_cars">passingCars</a>
     */
    @RecordMethodInfo(link = CODILITY_LINK + "5-prefix_sum/passing_cars")
    public static int passingCars(int[] array) {
        System.out.println("Input array:" + Arrays.toString(array));
        int carsTravellingEast = 0;
        long passedCars = 0;
        for (int j : array) {
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
    public static int passingCars1(int[] array) {
        System.out.println("Input array:" + Arrays.toString(array));
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == 0 && array[j] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
