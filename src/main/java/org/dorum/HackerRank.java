package org.dorum;

import java.text.DecimalFormat;
import java.util.*;

public class HackerRank {

    public static void main(String[] args) {

        SinglyLinkedList llist = new SinglyLinkedList();
        llist.insertNode(16);
        llist.insertNode(13);
        llist.insertNode(7);
        printList(llist.head);
        printList(insertNodeAtPosition(llist.head, 1, 2));

//        printList(reverse(llist.head));

//        System.out.println(superDigit("9875", 4));
//        System.out.println(superDigit("123", 3));

//        System.out.println(counterGame(1073741824));
//        System.out.println(counterGame1(1073741824));
//
//        System.out.println(balancedSums(new ArrayList<>(List.of(1))));
//        System.out.println(balancedSums(new ArrayList<>(Arrays.asList(1, 2, 3))));
//        System.out.println(balancedSums(new ArrayList<>(Arrays.asList(1, 2, 3, 3))));
//        System.out.println(balancedSums1(new ArrayList<>(Arrays.asList(1, 2, 3, 3))));
//        System.out.println(balancedSums(new ArrayList<>(Arrays.asList(2, 0, 0, 0))));
//
//        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("kc", "iu"))));
//        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("uxf", "vof", "hmp"))));
//        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("abc", "lmp", "qrt"))));
//        System.out.println(gridChallenge(new ArrayList<>(Arrays.asList("ebacd", "fghij", "olmkn", "trpqs", "xywuv"))));

//        System.out.println(maxMin(2, new ArrayList<>(Arrays.asList(1, 4, 7, 2))));
//        System.out.println(maxMin(4, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 20, 30, 40, 100, 200))));

//        System.out.println(caesarCipher("abcdefghijklmnopqrstuvwxyz", 3));

//        findZigZagSequence(new int[]{1, 2, 3, 4, 5, 6, 7});

//        System.out.println(sockMerchant(9, new ArrayList<>(Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20))));
//        System.out.println(sockMerchant(7, new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 3, 2))));

//        System.out.println(lexicographicalCounter("amazon", 3));

//        xor();

//        System.out.println(countingSort(Arrays.asList(1, 1, 3, 2, 1)));

//        System.out.println(twoArrays(1, Arrays.asList(0, 1), Arrays.asList(0, 2)));

//        System.out.println(flippingBits(9));

//        plusMinus(new ArrayList<>(Arrays.asList(1, 1, 0, -1, -1)));
//        miniMaxSum(new ArrayList<>(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625)));
//        System.out.println(timeConversion("07:05:45PM"));
//        System.out.println(timeConversion("07:05:45AM"));
//        System.out.println(timeConversion("12:05:45PM"));
//        System.out.println(timeConversion("12:05:45AM"));

//        System.out.println(matchingStrings(Arrays.asList("ab", "ab", "abc"), Arrays.asList("ab", "abc", "bc")));

//        System.out.println(lonelyinteger(new ArrayList<>(Arrays.asList(1, 1, 2, 3, 2, 4, 4))));
//        System.out.println(lonelyinteger(new ArrayList<>(Arrays.asList(0, 0, 1, 2, 1))));

//        System.out.println(diagonalDifference(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
//                Arrays.asList(9, 8, 9))));

//        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
//        System.out.println(pangrams("We promptly judged"));

//        System.out.println(birthday(new ArrayList<>(Arrays.asList(2, 2, 1, 3, 2)), 4, 2));
//        System.out.println(birthday(new ArrayList<>(List.of(4)), 4, 1));
//        System.out.println(birthday(new ArrayList<>(Arrays.asList(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1)),
//                18, 7));

//        staircaseReverted(4);
//        staircase(4);

//        miniMaxSum2(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625));

//        System.out.println(isFibonacci(new int[]{1, 2, 3, 5, 8, 13, 21, 34, 55}));
//        createFibonacciSequence(10);

//        fibonacciRecursion(10);
    }

    //https://www.hackerrank.com/challenges/one-month-preparation-kit-plus-minus/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one
    public static void plusMinus(List<Integer> arr) {
        double zero = 0, positive = 0, negative = 0;
        double arrayLength = arr.size();
        for (Integer element : arr) {
            if (element > 0) {
                positive++;
            } else if (element < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        DecimalFormat dec = new DecimalFormat("#0.000000");
        System.out.println(arrayLength);
        System.out.println(dec.format(negative / arrayLength));
        System.out.println(dec.format(positive / arrayLength));
        System.out.println(dec.format(zero / arrayLength));
    }

    public static void miniMaxSum(List<Integer> arr) {
        long maximumSum = Long.MIN_VALUE;
        long minimumSum = Long.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            long sum = 0;
            for (int j = 0; j < arr.size(); j++) {
                if (j == i) {
                    continue;
                }
                sum = sum + arr.get(j);
            }
            if (maximumSum < sum) {
                maximumSum = sum;
            }

            if (sum < minimumSum) {
                minimumSum = sum;
            }
        }
        System.out.println(minimumSum + " " + maximumSum);
    }

    public static String timeConversion(String s) {
        System.out.println("Input time: " + s);
        String[] array = s.replace("AM", "").replace("PM", "").split(":");
        if (s.contains("P")) {
            int hour = Integer.parseInt(array[0]) + 12;
            hour = hour == 24 ? 12 : hour;
            return hour + ":" + array[1] + ":" + array[2];
        }
        if (s.contains("A") && array[0].equals("12")) {
            return "00:" + array[1] + ":" + array[2];
        }
        return s.substring(0, s.length() - 2);
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (String query : queries) {
            for (String string : strings) {
                if (query.equals(string)) {
                    counter++;
                }
            }
            result.add(counter);
            counter = 0;
        }
        return result;
    }

    public static int lonelyInteger(List<Integer> a) {
        System.out.println("Input array: " + a);
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            if (i != a.size() - 1 && a.get(i).equals(a.get(i + 1))) {
                System.out.println("Pair found: " + a.get(i) + "-" + a.get(i + 1));
                i++;
            } else {
                return a.get(i);
            }
        }

//        a.stream()
//                .filter(item -> a.indexOf(item) == a.lastIndexOf(item))
//                .collect(toList())
//                .get(0);

        return a.get(0);
    }

    public static long flippingBits(long n) {
        System.out.println("Input: " + n);
        long[] binary = new long[32];
        int counter = 1;
        while (n > 0) {
            if (n % 2 == 0) {
                binary[binary.length - counter] = 0L;
            } else {
                binary[binary.length - counter] = 1L;
            }
            n = n / 2;
            counter++;
        }
        System.out.println("Converted decimal: " + Arrays.toString(binary));
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == 0) {
                binary[i] = 1;
            } else {
                binary[i] = 0;
            }
        }
        System.out.println("Converted array: " + Arrays.toString(binary));
        long result = 0;
        for (int i = 0; i < binary.length; i++) {
            result += (long) (binary[binary.length - i - 1] * Math.pow(2, i));
        }
        return result;
    }


    public static int diagonalDifference(List<List<Integer>> arr) {
        int counter = 0, left = 0, right = 0;
        for (List<Integer> row : arr) {
            left = left + row.get(counter);
            right = right + row.get(row.size() - counter - 1);
            counter++;
        }
        return Math.abs(left - right);
    }

    public static String pangrams(String s) {
        List<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < 122 - 97; i++) {
            alphabet.add((char) (97 + i));
        }
        for (Character character : s.toLowerCase().toCharArray()) {
            if (97 <= character && character <= 122) {
                alphabet.remove(character);
            }
        }
        if (alphabet.isEmpty()) {
            return "pangram";
        } else {
            return "not pangram";
        }
    }

    public static int birthday(List<Integer> array, int sumOfWindow, int windowSize) {
        int tempSum = 0, counter = 0;
        for (int i = 0; i <= array.size() - windowSize; i++) {
            for (int j = i; j < i + windowSize; j++) {
                tempSum = tempSum + array.get(j);
            }
            if (tempSum == sumOfWindow) {
                counter++;
            }
            tempSum = 0;
        }
        return counter;
    }

    public static void staircaseReverted(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = n - i; k < n + 1; k++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void miniMaxSum2(List<Integer> arr) {
        long maxSum = Long.MIN_VALUE;
        long minSum = Long.MAX_VALUE;
        long temp = 0;
        for (int i = 0; i < arr.size() - 3; i++) {
            for (int j = i; j < i + 4; j++) {
                temp = temp + arr.get(j);
            }
            if (temp >= maxSum) {
                maxSum = temp;
            }
            if (temp <= minSum) {
                minSum = temp;
            }
            temp = 0;
        }
        System.out.println(minSum + " " + maxSum);
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceCounter = 0, bobCounter = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                aliceCounter++;
            } else if (a.get(i) < b.get(i)) {
                bobCounter++;
            }
        }
        return Arrays.asList(aliceCounter, bobCounter);
    }

    public static boolean isFibonacci(int[] arr) {
        for (int i = arr.length - 1; i > 1; i--) {
            if (arr[i] != arr[i - 1] + arr[i - 2]) {
                System.out.println(arr[i] + " != " + arr[i - 1] + " + " + arr[i - 2]);
                return false;
            } else {
                System.out.println(arr[i] + " = " + arr[i - 1] + " + " + arr[i - 2]);
            }
        }
        return true;
    }

    public static void createFibonacciSequence(int amount) {
        int n1 = 1, n2 = 2, n3;
        System.out.print(n1 + "-" + n2);
        for (int i = 0; i < amount; i++) {
            n3 = n1 + n2;
            System.out.print("-");
            System.out.print(n3);
            n1 = n2;
            n2 = n3;
        }
    }

    private static int n1 = 1, n2 = 2;

    public static void fibonacciRecursion(int counter) {
        int n3 = n1 + n2;
        System.out.print("-");
        System.out.print(n3);
        n1 = n2;
        n2 = n3;
        counter--;
        if (counter > 0) {
            fibonacciRecursion(counter);
        }
    }

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        arr.sort(Collections.reverseOrder());
        long arrSum = arr.stream().mapToInt(Integer::intValue).sum();
        long halfSum = arrSum / 2 + 1;
        System.out.println("Array sum: " + arrSum);
        System.out.println("Half sum: " + halfSum);
        int boxA = 0;
        int index = 0;
        for (int i = 0; i < arr.size(); i++) {
            boxA += arr.get(i);
            if (arrSum - boxA < halfSum) {
                index = i;
                break;
            }
        }
        List<Integer> result = new ArrayList<>();
        System.out.println("Index: " + index);
        while (index >= 0) {
            result.add(arr.get(index));
            index--;
        }
        return result;
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        Collections.sort(A);
        B.sort(Collections.reverseOrder());

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) + B.get(i) < k) {
                return "NO";
            }
        }
        return "YES";
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(100, 0));
        for (Integer integer : arr) {
            result.set(integer, result.get(integer) + 1);
        }

//        for (int i = 0; i < result.size(); i++) {
//            if (result.get(i) != 0) {
//                for (int j = 0; j < result.get(i); j++) {
//                    System.out.print(i + "-");
//                }
//            }
//        }
//        System.out.println();
        return result;
    }

    public static void xor() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String s, t;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        t = in.nextLine();
        char[] line1 = s.toCharArray();
        char[] line2 = t.toCharArray();
        StringBuilder xor = new StringBuilder();
        for (int i = 0; i < line1.length; i++) {
            if (line1[i] != line2[i]) {
                xor.append("1");
            } else {
                xor.append("0");
            }
        }
        System.out.println(xor);
    }

    public static int lexicographicalCounter(String word, int substring) {
        int counter = 0;
        for (int i = 0; i < word.length() - substring + 1; i++) {
            char[] wordArray = word.toCharArray();
            for (int j = 0; j < substring / 2; j++) {
                char temp = wordArray[j + i + substring - 1];
                wordArray[j + i + substring - 1] = wordArray[j + i];
                wordArray[j + i] = temp;
            }
            System.out.println("Modified string: " + String.valueOf(wordArray));
            if (String.valueOf(wordArray).compareTo(word) < 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        int counter = 0;
        Collections.sort(ar);
        System.out.println("Sorted array: " + ar);
        for (int i = 0; i < n - 1; i++) {
            if (ar.get(i).equals(ar.get(i + 1))) {
                System.out.println(i + "-" + (i + 1));
                counter++;
                i = i + 1;
            }
        }
        return counter;
    }

    public static void findZigZagSequence(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int mid = (n - 1) / 2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;
        int st = mid + 1;
        int ed = n - 2;
        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static int pageCount(int n, int p) {
        int maxTurns = n / 2;
        int middle = maxTurns / 2;
        int turn = p / 2;
        if (turn > middle) {
            return maxTurns - turn;
        }
        return turn;
    }

    public static int towerBreakers(int n, int m) {
        // Write your code here
        int blocksSum = n * m;
        int turn = 0;
        while (blocksSum != 2) {
            if (m % 2 == 0) {
                blocksSum = blocksSum - (m / 2);
            } else
                turn += 1;
        }

        return turn % 2 == 0 ? 1 : 2;
    }

    public static String caesarCipher(String s, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            k = k - (k / 26) * 26;
            int characterCode = s.charAt(i) + k;

            if (!Character.isLetter(s.charAt(i))) {
                result.append(s.charAt(i));
            } else {
                if (Character.isLowerCase(s.charAt(i))) {
                    if (characterCode > 122) {
                        characterCode = characterCode - 122 + 96;
                    }
                } else {
                    if (characterCode > 90) {
                        characterCode = characterCode - 90 + 64;
                    }
                }
                result.append(Character.toString(characterCode));
            }
        }
        return result.toString();
    }


    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int unfairness = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - k + 1; i++) {
            int buffer = arr.get(k + i - 1) - arr.get(i);
            if (buffer < unfairness) {
                unfairness = buffer;
            }
        }
        return unfairness;
    }

    public static String gridChallenge(List<String> grid) {
        for (int i = 0; i < grid.size(); i++) {
            char[] array = grid.get(i).toCharArray();
            Arrays.sort(array);
            grid.set(i, String.valueOf(array));
        }
        System.out.println(grid);
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size() - 1; j++) {
                System.out.println(grid.get(j).charAt(i) + "-" + grid.get(j + 1).charAt(i));
                if (grid.get(j).charAt(i) > grid.get(j + 1).charAt(i)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static String balancedSums(List<Integer> arr) {
        System.out.println("Input array: " + arr);
        for (int i = 0; i < arr.size(); i++) {
            int leftSum = 0, rightSum = 0;
            boolean flag = false;
            for (int j = 0; j < arr.size(); j++) {
                if (i == j) {
                    flag = true;
                    continue;
                }
                if (flag) {
                    rightSum = rightSum + arr.get(j);
                } else {
                    leftSum = leftSum + arr.get(j);
                }
            }
            System.out.println(leftSum + " - " + rightSum);
            if (rightSum == leftSum) {
                return "YES";
            }
        }
        return "NO";
    }

    public static String balancedSums1(List<Integer> arr) {
        System.out.println("Input array: " + arr);
        int totalSum = arr.stream().mapToInt(Integer::intValue).sum();
        int currentSum = 0;
        for (Integer integer : arr) {
            currentSum = currentSum + integer;
            if (totalSum == currentSum) {
                return "YES";
            }
            totalSum = totalSum - integer;
            System.out.println(currentSum + " - " + totalSum);
        }
        return "NO";
    }

    public static int flippingTheMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int first = Collections.max(Arrays.asList(
                matrix.get(0).get(0),
                matrix.get(0).get(matrix.size() - 1),
                matrix.get(matrix.size() - 1).get(0),
                matrix.get(matrix.size() - 1).get(matrix.size() - 1)));
        int second = 0, third = 0, fourth = 0;
        return 0;
    }

    public static String counterGame(long n) {
        System.out.println("Input value: " + n);
        int turn = 0;
        while (n > 1) {
            System.out.println("n = " + n);
            double log = Math.log(n) / Math.log(2);
            System.out.println("log2(" + n + ") = " + log);
//            double remainder = log - Math.floor(log);
            double remainder = log % 1;
            System.out.println("Remainder = " + remainder);
            if (remainder == 0.0) {
                n = n / 2;
                System.out.println("n / 2 = " + n);
            } else {
                int pow = 2;
                double result = 0;
                while (n > result) {
                    result = Math.pow(2, pow);
                    pow++;
                }
                n = (long) (n - Math.pow(2, pow - 2));
                System.out.println("Nearest value 2^" + (pow - 2) + " = " + n);
            }
            turn++;
            System.out.println("Turn " + turn);
            System.out.println("+++++++++++++");
        }
        return turn % 2 == 0 ? "Richard" : "Louise";
    }

    public static String counterGame1(long n) {
        System.out.println("Input value: " + n);
        int turn = 0;
        boolean flag = true;
        while (n > 1) {
            int pow = 1;
            double result = 0;
            System.out.println("n = " + n);
            while (n > result) {
                result = Math.pow(2, pow);
                if (n == result) {
                    System.out.println("2 ^ " + pow + " = " + n);
                    n = n / 2;
                    System.out.println("n / 2 = " + n);
                    turn++;
                    flag = false;
                    break;
                }
                pow++;
            }
            if (flag) {
                n = (long) (n - Math.pow(2, pow - 2));
                System.out.println("Nearest value 2^" + (pow - 2) + " = " + n);
                turn++;
            }
            System.out.println("Turn " + turn);
        }
        return turn % 2 == 0 ? "Richard" : "Louise";
    }

    public static int superDigit(String n, int k) {
        System.out.println(n);
        long result = 0;
        for (int i = 0; i < n.length(); i++) {
            result += k * Long.parseLong(String.valueOf(n.charAt(i)));
        }
        k = 1;
        n = String.valueOf(result);
        if (result >= 10) {
            result = superDigit(n, k);
        }
        return (int) result;
    }


    public static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    public static void printList(SinglyLinkedListNode node) {
        int counter = 0;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
            counter++;
        }
        System.out.println("Amount of nodes: " + counter);
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
        SinglyLinkedListNode previousNode = null;
        while (currentNode != null) {
            SinglyLinkedListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;

            currentNode = nextNode;
        }
        return previousNode;
    }

    //https://www.hackerrank.com/challenges/one-month-preparation-kit-insert-a-node-at-a-specific-position-in-a-linked-list/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-three
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode currentNode = llist,
                resultHead = new SinglyLinkedListNode(0),
                result = resultHead;
        int counter = 0;
        while (currentNode != null) {
            if (counter == position) {
                result.next = new SinglyLinkedListNode(data);
                result.next.next = currentNode;
                break;
            }
            counter++;
            result.next = new SinglyLinkedListNode(currentNode.data);
            result = result.next;
            currentNode = currentNode.next;
        }
        return resultHead.next;
    }
}
