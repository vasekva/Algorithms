package cinemaRoomManager.stage_2;

import java.util.Scanner;

/**
* STAGE 2
*
* Цели
* На этом этапе нужно прочитать из входных данных два положительных целых числа:
* количество рядов и количество мест в каждом ряду. Цена билета определяется следующими правилами:
*
* Если общее количество мест в экранном зале не более 60, то цена каждого билета составляет 10 долларов.
* В большом зале билеты стоят 10 долларов за переднюю половину рядов и 8 долларов за заднюю половину.
* Количество строк может быть нечетным, например, 9 строк.
* В этом случае первая половина - это первые 4 ряда, а вторая половина - это оставшиеся 5 рядов.
*/

public class Cinema {

    private void count_max_income(int num_all_seats, int num_rows, int num_seats_in_row) {
        int profit;

        if (num_all_seats < 60) {
            profit = num_all_seats * 10;
        } else {
            int first_half = (num_all_seats - (int)(Math.ceil(num_rows / 2.0)) * num_seats_in_row);
            int second_half = num_all_seats - first_half;
            profit = (first_half) * 10 + second_half * 8;
        }
        System.out.println("Total income: ");
        System.out.println("$" + profit);
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Scanner scanner;
        int num_rows;
        int num_seats_in_row;
        int num_all_seats;

        scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        num_rows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of seats in each row:");
        num_seats_in_row = Integer.parseInt(scanner.nextLine());
        scanner.close();
        num_all_seats = num_rows * num_seats_in_row;
        cinema.count_max_income(num_all_seats, num_rows, num_seats_in_row);
    }
}
