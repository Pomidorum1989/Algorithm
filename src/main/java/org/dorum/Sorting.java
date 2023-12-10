package org.dorum;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
//        int[] inputArray = new int[10];
//        Random random = new Random();
//        for (int i = 0; i < inputArray.length; i++) {
//            inputArray[i] = random.nextInt(100);
//        }

        int[] inputArray = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println("Input:" + Arrays.toString(inputArray));
        mergeSort(inputArray);
        System.out.println("Output:" + Arrays.toString(inputArray));
    }

    public static String invertString(String text) {
        String temp = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            if (Character.isLetter(text.charAt(i))) {
                temp = temp.concat(String.valueOf(text.charAt(i)));
            }
        }
        String result = "";
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                result = result.concat(String.valueOf(text.charAt(i)));
            } else {
                result = result.concat(String.valueOf(temp.charAt(j)));
                j++;
            }
        }
        return result;
    }

    public static void mergeSort(int[] inputArray) {
        int middleIndex = inputArray.length / 2;
        int[] leftArray = new int[middleIndex];
        int[] rightArray = new int[inputArray.length - middleIndex];

        if (inputArray.length < 2) {
            return;
        }

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = inputArray[i];
        }

        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = inputArray[i + middleIndex];
        }

        System.out.println("Left: " + Arrays.toString(leftArray));
        System.out.println("Right: " + Arrays.toString(rightArray));
        System.out.println("______________________");

        mergeSort(leftArray);
        mergeSort(rightArray);

        sort(inputArray, leftArray, rightArray);
    }

    private static void sort(int[] array, int[] leftArray, int[] rightArray) {
        int mainIndex = 0, leftIndex = 0, rightIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[mainIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[mainIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            mainIndex++;
        }

        while (leftIndex < leftArray.length) {
            array[mainIndex] = leftArray[leftIndex];
            mainIndex++;
            leftIndex++;
        }

        while (rightIndex < rightArray.length) {
            array[mainIndex] = rightArray[rightIndex];
            mainIndex++;
            rightIndex++;
        }
    }
}
