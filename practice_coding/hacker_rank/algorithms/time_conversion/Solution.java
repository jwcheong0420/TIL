package practice_coding.hacker_rank.algorithms.time_conversion;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        int hh = Integer.parseInt(s.substring(0, 2));
        int mm = Integer.parseInt(s.substring(3, 5));
        int ss = Integer.parseInt(s.substring(6, 8));
        if ("AM".compareTo(s.substring(8, 10)) == 0) {
            if (hh == 12) {
                hh = 0;
            }
        } else {
            if (hh != 12) {
                hh += 12;
            }
        }

        return String.format("%02d", hh) + ":" + String.format("%02d", mm) + ":" + String.format("%02d", ss);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
