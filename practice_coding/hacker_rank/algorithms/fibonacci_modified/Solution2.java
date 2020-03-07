package practice_coding.hacker_rank.algorithms.fibonacci_modified;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution2 {

    // Complete the fibonacciModified function below.
    static BigInteger fibonacciModified(int t1, int t2, int n) {
        ArrayList<BigInteger> answers = new ArrayList<>();
        answers.add(0, BigInteger.valueOf(t1));
        answers.add(1, BigInteger.valueOf(t2));

        for (int i = 2; i < n; i++) {
            BigInteger tn2 = answers.get(i - 2);
            BigInteger tn1 = answers.get(i - 1);
            answers.add(i, tn2.add(tn1.multiply(tn1)));
        }

        return answers.get(n - 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
