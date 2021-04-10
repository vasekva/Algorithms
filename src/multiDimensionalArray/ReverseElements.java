package multiDimensionalArray;

import java.util.Arrays;

/*
* Нужно реализовать reverseElements метод,
* переворачивающий все элементы в строках.
*
* Гарантируется передача в twoDimArray хотя бы 1 строки.
*/

public class ReverseElements {
    public static void reverseElements(int[][] twoDimArray) {
        int[]   tmpArray;
        int     len;

        for (int i = 0; i < twoDimArray.length; i++) {
            len = twoDimArray[i].length - 1;
            tmpArray = Arrays.copyOf(twoDimArray[i], twoDimArray[i].length);
            for (int j = 0; j < twoDimArray[i].length; j++) {
                twoDimArray[i][j] = tmpArray[len];
                len--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};

        for (int i = 0; i < array.length; i++) {
            System.out.print(Arrays.toString(array[i]));
        }
        System.out.println();
        reverseElements(array);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(Arrays.toString(array[i]));
        }
    }
}
