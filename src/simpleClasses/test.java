package simpleClasses;

import java.util.Arrays;
import java.util.regex.*;

public class test {

    public static void main(String[] args) {
        int[][] twoDimArray = new int[3][3];
        for (int i = 0; i < twoDimArray.length; i++) {
            Arrays.fill(twoDimArray[i], 1);
        }
        for (int i = 0; i < twoDimArray.length; i++) {
            if (i == 2) {
                for (int j = 0; j < twoDimArray[i].length; j++) {
                    System.out.print(twoDimArray[i][j] + " ");
                }
            }
        }
    }

    public static String[] sortArray(String[] array) {
        java.util.Arrays.sort(array);
        return array;
    }

}
