package org.dorum;

import java.util.Objects;

public class Habr {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21};
        int[] array1 = new int[]{};

        System.out.print(closestNumber(12, array) + "  ");
        System.out.print(closestNumber(13, array) + "  ");
        System.out.print(closestNumber(2, array) + "  ");
        System.out.print(closestNumber(22, array) + "  ");
        System.out.print(closestNumber(3, array) + "  ");
        System.out.print(closestNumber(21, array) + "  ");
        System.out.print(closestNumber(12, array1) + "  ");
        System.out.print(closestNumber(null, array) + "  ");
        System.out.println();
        System.out.print(closestNumber1(12, array) + "  ");
        System.out.print(closestNumber1(13, array) + "  ");
        System.out.print(closestNumber1(2, array) + "  ");
        System.out.print(closestNumber1(22, array) + "  ");
        System.out.print(closestNumber1(3, array) + "  ");
        System.out.print(closestNumber1(21, array) + "  ");
        System.out.print(closestNumber1(12, array1) + "  ");
        System.out.print(closestNumber1(null, array) + "  ");
    }

    //https://habr.com/ru/companies/ispsystem/articles/779224/
    public static int closestNumber(Integer number, int[] array) {
//        System.out.println("Input array: " + Arrays.toString(array));
//        System.out.println("Searching for " + number);
        if (Objects.isNull(number) || array.length == 0 || array[0] > number) {
            return -1;
        } else if (array[array.length - 1] < number) {
            return array[array.length - 1];
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return array[i];
            } else if (array[i] > number) {
                return array[i - 1];
            }
        }
        return -1;
    }

    //https://habr.com/ru/companies/ispsystem/articles/779224/
    public static int closestNumber1(Integer number, int[] array) {
//        System.out.println("Input array: " + Arrays.toString(array));
//        System.out.println("Searching for " + number);
        int start = 0;
        int end = array.length - 1;
        if (Objects.isNull(number) || array.length == 0 || array[0] > number) {
            return -1;
        } else if (array[end] < number) {
            return array[end];
        }

        int answer = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > number) {
                end = mid - 1;
            } else if (array[mid] < number) {
                answer = array[mid];
                start = mid + 1;
            } else {
                return array[mid];
            }
        }
        return answer;
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
}
