package cinemaRoomManager.stage_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
* STAGE 3
*
* Цели
* Считайте два положительных целых числа, которые представляют количество рядов и мест в каждом ряду,
* и распечатайте расположение сидений, как на первом этапе. Затем прочтите два целых числа из ввода:
* номер строки и номер места в этой строке. Эти числа представляют собой координаты места, по которому
* программа должна распечатать стоимость билета. Стоимость билета определяется по тем же правилам,
* что и на предыдущем этапе:
*
* Если общее количество мест в экранном зале не более 60, то цена каждого билета составляет 10 долларов.
* В большом зале билеты стоят 10 долларов за переднюю половину рядов и 8 долларов за заднюю половину.
* Обратите внимание, количество строк может быть нечетным, например, 9 строк. В этом случае первая половина -
* это первые 4 ряда, а вторая половина - это оставшиеся 5 рядов.
* После этого программа должна распечатать все места в экранной комнате, как показано в примере,
* и пометить выбранное место 'B' символом. Наконец, он должен распечатать цену билета и остановиться.
* Обратите внимание, что в этом проекте количество рядов и сидений не будет больше 9.
*/

public class Cinema {
    char[][] hall;

    private void fillArray(int numRows, int numSeatsInRow) {
        for (int i = 0; i < hall.length; i++) {
            for (int j = 0; j < hall[i].length; j++) {
                hall[i][j] = 'S';
            }
        }
    }

    private void printHall() {
        String str;

        System.out.println("\nCinema:");
        str = " ";
        for (int j = 0; j < hall[0].length; j++) {
            str += " " + (j + 1);
        }
        System.out.println(str);
        for (int i = 0; i < hall.length; i++) {
            str = "" + (i + 1);
            for (int j = 0; j < hall[i].length; j++) {
                str += " " + hall[i][j];
            }
            System.out.println(str);
        }
        System.out.println();
    }

    private boolean isSmallHall(int numSeats) {
        if (numSeats < 60) {
            return true;
        } else {
            return false;
        }
    }

    private void printTicketPrice(int numSeats, int numRows, int chosenRow) {
        int price;
        int lastRowFirstHalf;

        if (isSmallHall(numSeats)) {
            price = 10;
        } else {
            lastRowFirstHalf = (int)Math.floor(numRows / 2.0);
            if (chosenRow > lastRowFirstHalf) {
                price = 8;
            } else {
                price = 10;
            }
        }
        System.out.println("\nTicket price: $" + price);
    }

    private void buyTicket(int numAllSeats, int numRows) {
        int     chosenRow;
        int     seat;
        Scanner scanner;
        Cinema  cinema = new Cinema();

        scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        chosenRow = scanner.nextInt();
        if (chosenRow > 9 || chosenRow < 0) {
            throw new NumberFormatException("Число твечающее за ряд или место не может быть больше 9 и меньше 0!");
        }
        System.out.println("Enter a seat number in that row:");
        seat = scanner.nextInt();
        if (seat > 9 || seat < 0) {
            throw new NumberFormatException("Число твечающее за ряд или место не может быть больше 9 и меньше 0!");
        }
        cinema.printTicketPrice(numAllSeats, numRows, chosenRow);
        hall[chosenRow - 1][seat - 1] = 'B';
    }

    private void action(int numRows, int numSeatsInRow) {
        int     numAllSeats;
        Scanner scanner;
        int     choice;

        choice = 0;
        numAllSeats = numRows * numSeatsInRow;
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 0:
                    return ;
                case 1: printHall();
                    break;
                case 2: buyTicket(numAllSeats, numRows);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Scanner scanner;
        int numRows;
        int numSeatsInRow;

        scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        numRows = Integer.parseInt(scanner.nextLine());
        if (numRows > 9 || numRows < 1) {
            throw new NumberFormatException("Число твечающее за ряд или место не может быть больше 9 и меньше 1!");
        }
        System.out.println("Enter the number of seats in each row:");
        numSeatsInRow = Integer.parseInt(scanner.nextLine());
        System.out.println();
        if (numSeatsInRow > 9 || numSeatsInRow < 1) {
            throw new NumberFormatException("Число твечающее за ряд или место не может быть больше 9 и меньше 1!");
        }
        cinema.hall = new char[numRows][numSeatsInRow];
        cinema.fillArray(numRows, numSeatsInRow);
        cinema.action(numRows, numSeatsInRow);
        scanner.close();
    }
}
