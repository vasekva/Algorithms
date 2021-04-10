package multiDimensionalArray;

import java.util.Scanner;

/*
* В кинотеатре n рядов, каждый из m мест ( n и m не более 20).
* Двумерная матрица хранит информацию о проданных билетах, цифра 1 означает,
* что билет на это место уже продан, цифра 0 означает, что место доступно.
* Вы хотите купить k билетов на соседние места в том же ряду.
* Узнайте, можно ли это сделать.
*
* Формат входных данных
*
* На входе программа получает количество n рядов и m мест.
* Затем идут n строк, каждая из которых содержит m чисел ( 0 или 1 ),
* разделенных пробелами. В последней строке записано число k .
*
* Формат выходных данных
*
* Программа должна вывести номер строки с k последовательными доступными местами.
* Если имеется несколько рядов с k доступными местами, выведите первый ряд с этими сиденьями.
* Если такой строки нет, выведите число 0.
*/

public class Cinema {

    private void countAvailableSeats(int[][] array, int h, int w, int need) {
        int count;
        int row;
        int hasOneBefore;

        count = 0;
        row = 0;
        hasOneBefore = 0;
        first:
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (array[i][j] == 0) {
                    if (hasOneBefore == 1) {
                        count = 0;
                        hasOneBefore = 0;
                    }
                    count++;
                    if (count >= need) {
                        row = i + 1;
                        break first;
                    }
                }
                if (array[i][j] == 1) {
                    hasOneBefore = 1;
                }
            }
            count = 0;
            hasOneBefore = 0;
        }
        System.out.println(row);
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Scanner scanner;
        int[][] array;
        int     h;
        int     w;
        int     num;
        int     numOfSeatsRequired;

        scanner = new Scanner(System.in);
        h = scanner.nextInt();
        w = scanner.nextInt();
        if (h > 20 || w > 20) {
            throw new NumberFormatException("Размеры массива должны быть меньше 20!");
        }
        if (h < 1 || w < 1) {
            throw new NumberFormatException("Размеры массива должны быть больше 0!");
        }
        array = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                num = scanner.nextInt();
                if (num != 0 && num != 1) {
                    throw new NumberFormatException("Число в массиве можеть быть равно только 0 или 1!");
                }
                array[i][j] = num;
            }
        }
        numOfSeatsRequired = scanner.nextInt();
         if (numOfSeatsRequired > w)
             throw new NumberFormatException("Число нужных мест не может превышать кол-во мест в ряду!");
        if (numOfSeatsRequired < 1) {
            throw new NumberFormatException("Кол-во нужных мест должно быть равно как минимум одному!");
        }
        cinema.countAvailableSeats(array, h, w, numOfSeatsRequired);
    }
}
