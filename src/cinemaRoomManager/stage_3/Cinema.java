package cinemaRoomManager.stage_3;

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

    private void print_seats(int num_rows, int num_seats_in_row, int row, int seat) {
        String  str;

        System.out.println("\nCinema:");
        str = " ";
        for (int i = 0; i <= num_rows; i++) {
            for (int j = 0; j < num_seats_in_row; j++) {
                if (i == 0) {
                    str += " " + (j + 1);
                } else {
                    if ((i != row || j != seat - 1)) {
                        str += " S";
                    } else {
                        str += " B";
                    }
                }
            }
            System.out.println(str);
            str = "" + (i + 1);
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

    private void printTicketPrice(int numSeats, int numRows, int row) {
        int price;
        int lastRowFirstHalf;

        if (isSmallHall(numSeats)) {
            price = 10;
        } else {
            lastRowFirstHalf = (int)Math.floor(numRows / 2.0);
            if (row > lastRowFirstHalf) {
                price = 8;
            } else {
                price = 10;
            }
        }
        System.out.println("\nTicket price: $" + price);
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Scanner scanner;
        int numRows;
        int numSeatsInRow;
        int numAllSeats;
        int row;
        int seat;

        scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        numRows = Integer.parseInt(scanner.nextLine());
        if (numRows > 9 || numRows < 0) {
            throw new NumberFormatException("Число твечающее за ряд или место не может быть больше 9 и меньше 0!");
        }
        System.out.println("Enter the number of seats in each row:");
        numSeatsInRow = Integer.parseInt(scanner.nextLine());
        if (numSeatsInRow > 9 || numSeatsInRow < 0) {
            throw new NumberFormatException("Число твечающее за ряд или место не может быть больше 9 и меньше 0!");
        }
        numAllSeats = numRows * numSeatsInRow;
        cinema.print_seats(numRows, numSeatsInRow, -1, -1);
        System.out.println("Enter a row number:");
        row = scanner.nextInt();
        if (row > 9 || row < 0) {
            throw new NumberFormatException("Число твечающее за ряд или место не может быть больше 9 и меньше 0!");
        }
        System.out.println("Enter a seat number in that row:");
        seat = scanner.nextInt();
        if (seat > 9 || seat < 0) {
            throw new NumberFormatException("Число твечающее за ряд или место не может быть больше 9 и меньше 0!");
        }
        cinema.printTicketPrice(numAllSeats, numRows, row);
        cinema.print_seats(numRows, numSeatsInRow, row, seat);
        scanner.close();
    }
}
