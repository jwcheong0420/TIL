package practice_coding.hacker_rank.algorithms.big_sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution4 {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length();
            }
        });
        return unsorted;
    }

    // private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int n = scanner.nextInt();
        int n = Integer.parseInt(reader.readLine());
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            // String unsortedItem = scanner.nextLine();
            String unsortedItem = reader.readLine();
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

        // scanner.close();
        reader.close();
    }
}
