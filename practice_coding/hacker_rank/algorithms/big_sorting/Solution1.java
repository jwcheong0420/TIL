package practice_coding.hacker_rank.algorithms.big_sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution1 {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        BigInteger[] arr = new BigInteger[unsorted.length];
        for (int i = 0; i < unsorted.length; i++) {
            arr[i] = new BigInteger(unsorted[i]);
        }
        Arrays.sort(arr);
        String[] sorted = new String[unsorted.length];
        for (int i = 0; i < unsorted.length; i++) {
            sorted[i] = arr[i].toString();
        }
        return sorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
