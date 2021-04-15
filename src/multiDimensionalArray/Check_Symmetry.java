package multiDimensionalArray;

/*
* Дано число n, не превышающее 5, и матрица размера n × n.
* Нужно проверить, является ли эта матрица симметричной относительно главной диагонали.
* Вывести слово «YES», если оно симметрично, и слово «NO» в противном случае.
*
* Основная диагональ идет от верхнего левого угла к нижнему правому углу.
*/

import java.util.Scanner;

public class Check_Symmetry {

    private boolean checkMatrix(int[][] array, int size) {
        for (int i = 0, j = 0; i < size; i++, j++) {
            array[i][j] = 1;
            for (int w = j; w >= 0; w--) {
                if (array[i][w] != array[w][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Check_Symmetry      symmetry;
        Scanner             scanner;
        int[][]             array;
        int                 size;
        int                 num;

        symmetry = new Check_Symmetry();
        scanner = new Scanner(System.in);
        size = scanner.nextInt();
        if (size < 1 || size > 5) {
            throw new NumberFormatException("Размер массива должен быть больше 1 и меньше 6!");
        }
        array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                num = scanner.nextInt();
                array[i][j] = num;
            }
        }
        if (!symmetry.checkMatrix(array, size)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
