package simpleClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfDecompositions {

    static void printPartitions(int target, int maxValue, String suffix) {
        if (target == 0)
            System.out.println(suffix);
        else {
            if (maxValue > 1) {
                printPartitions(target, maxValue-1, suffix);
            }
            if (maxValue <= target)
                printPartitions(target-maxValue, maxValue, maxValue + " " + suffix);
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        try {
            num = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        printPartitions(num, num, "");
    }
}
