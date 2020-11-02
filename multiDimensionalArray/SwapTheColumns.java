package multiDimensionalArray;

import java.util.Scanner;

public class SwapTheColumns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int line = scanner.nextInt();
        int column = scanner.nextInt();

        int[][] array = new int[line][column];

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int firstColumn = scanner.nextInt();
        int secondColumn = scanner.nextInt();

        for (int i = 0; i < line; i++) {
            int buf = array[i][firstColumn];
            array[i][firstColumn] = array[i][secondColumn];
            array[i][secondColumn] = buf;

        }

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
