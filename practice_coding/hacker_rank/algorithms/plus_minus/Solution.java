package practice_coding.hacker_rank.algorithms.plus_minus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int pos = 0, neg = 0, zero = 0;
        for (int num : arr) {
            if (num > 0) {
                pos += 1;
            } else if (num < 0) {
                neg += 1;
            } else {
                zero += 1;
            }
        }

        System.out.println(String.format("%.6f", (double) pos / arr.length));
        System.out.println(String.format("%.6f", (double) neg / arr.length));
        System.out.println(String.format("%.6f", (double) zero / arr.length));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
