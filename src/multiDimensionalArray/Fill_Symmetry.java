package multiDimensionalArray;

import java.util.Scanner;

/*
* Дано число n, необходимо создать матрицу n * n
* и заполнить ячейки по диагонали(от левого нижнего угла до правого верхнего),
* каждая последующая диагональ должна быть заполнена числом на единицу больше предшествующей
*/

public class Fill_Symmetry {

    private int[][]    fillMatrix(int size) {
        int     num;
        int[][] array;


        num = 0;
        array = new int[size][size];
        /*
         * цикл выполняется size раз, доходя до левого нижнего угла,
         * каждый внутренний цикл начинается с нулевой ячейки новой строки
         * и каждая итерация передвигает положение ячейки на i--, j++
         * (правее и выше на 1)
         */
        for (int c = 0; c < size; c++) {
            for (int i = c, j = 0; i >= 0; i--, j++) {
                array[i][j] = num;
            }
            num++;
        }
        /*
         * цикл выполняется size - 1 раз, передвигая каждый раз стартовую позицию,
         * правее по последней строке, начиная с ячейки под индексом 1
         * и каждая итерация передвигает положение ячейки на i--, j++
         * (правее и выше на 1)
         */
        for (int c = 1; c < size; c++) {
            for (int i = size - 1, j = c; j <= size - 1; i--, j++) {
                array[i][j] = num;
            }
            num++;
        }
        return array;
    }

    private void printArray(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j + 1 == size) {
                    System.out.print(array[i][j]);
                } else {
                    System.out.print(array[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Fill_Symmetry      symmetry;
        Scanner             scanner;
        int                 size;

        symmetry = new Fill_Symmetry();
        scanner = new Scanner(System.in);
        size = scanner.nextInt();
        if (size < 1)
            throw new NumberFormatException("Размер массива должен быть больше 1!");
        symmetry.printArray(symmetry.fillMatrix(size), size);
    }
}