package multiDimensionalArray;

import java.util.Scanner;

/*
* Дан двумерный массив (матрица) и два числа: i и j.
* Необходимо поменять местами столбцы с индексами i и j в матрице.
*
* Входные данные содержат размеры матрицы n и m, не превышающие 100,
* затем элементы матрицы, затем индексы i и j.
*/

public class SwapTheColumns {

    private void swapAndPrintArr(int[][] array, int first, int second) {
        // цикл замены
        for (int i = 0; i < array.length; i++) {
            int buf = array[i][first];
            array[i][first] = array[i][second];
            array[i][second] = buf;

        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SwapTheColumns  swap;
        Scanner         scanner;
        int             firstCol;
        int             secondCol;
        int[][]         array;
        int             h;
        int             w;

        swap = new SwapTheColumns();
        scanner = new Scanner(System.in);
        h = scanner.nextInt();
        w = scanner.nextInt();
        array = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        firstCol = scanner.nextInt();
        secondCol = scanner.nextInt();
        swap.swapAndPrintArr(array, firstCol, secondCol);
    }
}
