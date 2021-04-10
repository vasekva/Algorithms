package multiDimensionalArray;

import java.util.Scanner;

/*
* Нужно найти индексы начального появления максимального элемента в матрице.
*
* Формат входных данных
*
* На входе программа получает размер матрицы n и m,
* а затем n строк по m целых чисел в каждой. n и m не превышают 100.
*
* Формат выходных данных
*
* Выведите два числа: индекс строки и индекс столбца,
* в котором находится наибольший элемент двумерного массива (матрицы).
* Если таких элементов несколько, выведите тот, у которого индекс строки меньше;
* и если индексы строк совпадают, выведите ту, у которой индекс столбца меньше.
*/

public class FindIndexMaxElem {

    private int findMaxValue(int[][] array, int h, int w) {
        int max;

        max = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    private void printIndMaxValue(int[][] array, int h, int w, int max) {
        first:
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (array[i][j] == max) {
                    System.out.println(i + " " + j);
                    break first;
                }
            }
        }
    }

    public static void main(String[] args) {
        FindIndexMaxElem   findIndexMaxElem;
        Scanner         scanner;
        int[][]         array;
        int             max;
        int             h;
        int             w;

        findIndexMaxElem = new FindIndexMaxElem();
        scanner = new Scanner(System.in);
        h = scanner.nextInt();
        w = scanner.nextInt();
        if (h > 100 || w > 100 || h < 1 || w < 1) {
            throw new NumberFormatException("Размеры массива должны быть меньше 100 и больше 0!");
        }
        array = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        max = findIndexMaxElem.findMaxValue(array, h, w);
        findIndexMaxElem.printIndMaxValue(array, h, w, max);
    }
}
