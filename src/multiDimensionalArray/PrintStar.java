package multiDimensionalArray;

import java.util.Scanner;

/*
* Дано нечетное число n, не превышающее 15.
* Нужно создать двумерный массив (матрицу) из n × n элементов,
* заполнив его знаком «.» символы (каждый элемент матрицы представляет собой строку,
* содержащую один символ). Затем нужно заполнить среднюю строку матрицы, средний столбец,
* а также главную и второстепенную диагонали символами «*».
* В результате все "*" в массиве должны образовывать звезду.
* Вывести эту матрицу;
* элементы массива должны быть разделены пробелами.
*/

public class PrintStar {

    private void printArray(char[][] array, int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j]);
                if (j + 1 != size) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    private void replaceSymbols(char[][] array, int size) {
        int middle_line;
        int middle_column;

        middle_line = (int)Math.floor(size / 2.0);
        middle_column = middle_line;
        for (int i = 0; i < size; i++) {
            array[middle_line][i] = '*';
        }
        for (int i = 0; i < size; i++) {
            array[i][middle_column] = '*';
        }
        // проходка с левого верхнего угла до правого нижнего
        for (int i = 0, j = 0; i < size; j++, i++) {
                array[i][j] = '*';
        }
        // проходка с левого нижнего угла до правого верхнего
        for (int i = 0, j = size - 1; i < size; i++, j--) {
            array[i][j] = '*';
        }
    }

    public static void main(String[] args) {
        PrintStar printStar = new PrintStar();
        Scanner scanner;
        char[][] array;
        int     size;

        scanner = new Scanner(System.in);
        size = scanner.nextInt();
        if (size % 2 == 0 || size < 1 || size > 15)
            throw new NumberFormatException("Число должно быть нечетным и при этом больше 0 и меньше 15!");
        array = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = '.';
            }
        }
        printStar.replaceSymbols(array, size);
        printStar.printArray(array, size);
    }
}
