package multiDimensionalArray;

import java.util.Scanner;

/*
* Учитывая число n, не больше 100, cоздать матрицу размера n × n и заполнить ее по следующему правилу.
* Цифры 0 должны храниться на первичной (главной) диагонали.
* Две диагонали, примыкающие к основной, должны содержать числа 1.
* Следующие две диагонали должны содержать числа 2; и т.п.
*
* Примечание: основная диагональ проходит от верхнего левого угла до нижнего правого угла.
*
* Образец:
*
* 0 1 2 3
* 1 0 1 2
* 2 1 0 1
* 3 2 1 0
*/

public class FillTheMatrix_v2 {

    private int[][] fillMatrix(int size) {
        int[][] array;

        array = new int[size][size];
        for (int n = 1; n < size; n++) {
            // заполняет диагонали выше от центральной
            for (int i = 0, j = n; j < size; i++, j++) {
                array[i][j] = n;
            }
            // заполняет среднюю диагональ от левого верхнего до правого верхнего
            for (int i = 0, j = 0; j < size; i++, j++) {
              array[i][j] = 0;
            }
            // заполняет диагонали ниже от центральной
            for (int i = n, j = 0; i < size; i++, j++) {
                array[i][j] = n;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        FillTheMatrix_v2    fillTheMatrix;
        Scanner             scanner;
        int[][]             array;
        int                 size;

        fillTheMatrix = new FillTheMatrix_v2();
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
