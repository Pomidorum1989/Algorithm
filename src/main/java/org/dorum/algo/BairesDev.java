package org.dorum.algo;

import java.util.Arrays;

public class BairesDev {

    public static void main(String[] args) {

//        cinema(5, 12, new int[]{0, 0, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1});

//        int[][] array = new int[][]{
//                {987654423, 4},
//                {987654220, 5},
//                {987654202, 4},
//                {987654250, 1},
//                {987654419, 5},
//        };
//
//        int[][] array2 = new int[][]{
//                {987654171, 3},
//                {987654478, 3},
//                {987654092, 4},
//                {987654421, 3},
//                {987654001, 4}
//        };
//
//        restaurant(array.length, array2);

        timeConverter(173635816 );
    }

    public static int[] cinema(int N, int K, int[] seat) {
        int[] result = new int[K];
        Arrays.fill(result, 0);
        for (int j = 0; j < N; j++) {
            int minSeatNumber = 0;
            for (int i = 1; i <= result.length; i++) {
                if (result[i] == 0 && minSeatNumber < i) {
                    minSeatNumber = i;
                }
            }
            result[minSeatNumber] = minSeatNumber;
        }
        return result;
    }

    public static int restaurant(int N, int[][] ratings) {
        System.out.println(N);
        int result;
        int maxRating = ratings[0][1];
        int smallestId = ratings[0][0];
        for (int[] rating : ratings) {
            if (rating[1] > maxRating) {
                maxRating = rating[1];
                smallestId = rating[0];
            } else if (rating[1] == maxRating && rating[0] < smallestId) {
                smallestId = rating[0];
            }
        }
        System.out.println(smallestId);
        result = smallestId;
        return result;
    }

    public static String timeConverter(int seconds) {
        StringBuilder stringBuilder = new StringBuilder();

        long years = seconds / (3600L * 24 * 365);
        long remainder = seconds % (3600L * 24 * 365);

        long days = remainder / (3600L * 24);
        remainder %= (3600L * 24);

        long hours = remainder / 3600L;
        remainder %= 3600L;

        long minutes = remainder / 60L;
        remainder %= 60L;

        long second = remainder;

        if (years > 0) {
            stringBuilder.append(years).append(years > 1 ? " years " : " year ");
        }
        if (days > 0) {
            stringBuilder.append(days).append(days > 1 ? " days " : " day ");
        }
        if (hours > 0) {
            stringBuilder.append(hours).append(hours > 1 ? " hours " : " hour ");
        }
        if (minutes > 0) {
            stringBuilder.append(minutes).append(minutes > 1 ? " minutes " : " minute ");
        }
        if (second > 0) {
            stringBuilder.append(second).append(second > 1 ? " seconds " : " second ");
        }

        System.out.println(stringBuilder);
        return stringBuilder.toString().trim();
    }
}
