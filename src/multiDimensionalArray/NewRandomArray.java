package multiDimensionalArray;

import java.util.Scanner;

public class NewRandomArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        newArray(size);
    }

    public static int[][] newArray(int size) {
        int[][] array = new int[size][size];

        //System.out.println(1 + (int) (Math.random() * 10));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int num = 1 + (int) (Math.random() * 100);
                array[i][j] = num;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        return array;
    }
}
