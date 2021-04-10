package multiDimensionalArray;

import java.util.Scanner;

/*
* Дан прямоугольный массив размером n × m.
* Необходимо повернуть его на 90 градусов по часовой стрелке,
* записав результат в новый массив размером m × n.
*
* Формат входных данных
*
* Введите два числа n и m, не превышающих 100, а затем массив размером n × m.
*
* Формат выходных данных
*
* Выведите получившийся массив. Разделяйте числа в выводе одним пробелом.
*/

public class RotateArray {

    private void printArray(int[][] array, int w, int h) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                System.out.print(array[i][j]);
                if (j + 1 != h) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private int[][] rotate(int[][] array, int h, int w) {
        int[][] newArray;

        newArray = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                newArray[i][h - j - 1] = array[j][i];
                // элемент нулевой строчки нулевого столбца старого массива
                // =  элементу нулевой строчки последнего столбца старого массива
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        Scanner scanner;
        int[][] array;
        int     h;
        int     w;

        scanner = new Scanner(System.in);
        h = scanner.nextInt();
        w = scanner.nextInt();
        if (h > 100 || w > 100)
            throw new NumberFormatException("Размеры массива должны быть меньше 100!");
        if (h < 2 || w < 2)
            throw new NumberFormatException("Размеры массива должны быть больше 2!");
        array = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        array = rotateArray.rotate(array, h, w);
        rotateArray.printArray(array, w, h);
    }
}
