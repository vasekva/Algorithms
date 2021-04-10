package multiDimensionalArray;

import java.util.Scanner;

/*
* Учитывая число n, не больше 100, cоздать матрицу размера n × n и заполнить ее по следующему правилу.
* Cтороны куба должны быть заполнены по часовой стрелке значениями от 0 до size,
* прилегающая к ней по часовой стрелке сторона должна быть заполнена числами от size до 0,
* далее форма заполнения должна производится от 0 до size и от size до 0 соответственно.
*
* Главная диагональ (от верхнего левого угла до правого нижнего) должна быть заполнена нулями,
* перпендикулярная - двойками
*
*/

public class FillTheMatrix {

    private void fillFirstAndLastLines(int[][] array, int size) {
        int pos;
        int j;

        pos = 0;
        j = 0;
        while (j < size) {
            array[0][j] = j;
            j++;
        }
        while (--j > 0) {
            array[size - 1][pos] = j;
            pos++;
        }
    }

    private void fillFirstAndLastColumns(int[][] array, int size) {
        int pos;
        int j;

        pos = 0;
        j = 0;
        while (j < size) {
            array[j][0] = j;
            j++;
        }
        while (--j > 0) {
            array[pos][size - 1] = j;
            pos++;
        }
    }

    private void fillDiagonals(int[][] array, int size) {
        // диагональ внутренного куба(size - 1) с правого верхнего угла до левого нижнего
        for (int i = 1, j = size - 2; i < size - 1; i++, j--) {
            array[i][j] = 2;
        }
        // диагональ с верхнего левого угла в правый нижний
        for (int i = 0, j = 0; i < size; i++, j++) {
            array[i][j] = 0;
        }

    }

    private int[][] fillMatrix(int size) {
        int[][] array;

        array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = 1;
            }
        }
        fillFirstAndLastLines(array, size);
        fillFirstAndLastColumns(array, size);
        fillDiagonals(array, size);
        return array;
    }

    public static void main(String[] args) {
        FillTheMatrix   fillTheMatrix;
        Scanner         scanner;
        int[][]         array;
        int             size;

        fillTheMatrix = new FillTheMatrix();
        scanner = new Scanner(System.in);
        size = scanner.nextInt();
        if (size < 1 || size > 100)
            throw new NumberFormatException("Размер массива должен быть больше 1 и меньше 100!");
        array = fillTheMatrix.fillMatrix(size);
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
}
