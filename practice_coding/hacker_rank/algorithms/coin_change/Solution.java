package practice_coding.hacker_rank.algorithms.coin_change;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER. The function accepts
     * following parameters: 1. INTEGER n 2. LONG_INTEGER_ARRAY c
     */

    public static long[][] tabulation(int n, List<Long> c) {
        int type = c.size();
        int[] intC = new int[type];
        for (int i = 0; i < type; i++) {
            intC[i] = c.get(i).intValue();
        }

        long[][] table = new long[n + 1][type];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < type; j++) {
                if (i == 0) {
                    table[0][j] = 1; // only one way : not using coin
                } else {
                    long excludeNewCoin = 0, includeNewCoin = 0;
                    if (j != 0) {
                        excludeNewCoin = table[i][j - 1];
                    }
                    if (i - intC[j] >= 0) {
                        includeNewCoin = table[i - intC[j]][j];
                    }
                    table[i][j] = excludeNewCoin + includeNewCoin;
                }
            }
        }
        return table;
    }

    public static long getWays(int n, List<Long> c) {
        long[][] table = tabulation(n, c);
        return table[n][c.size() - 1];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having
        // the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
