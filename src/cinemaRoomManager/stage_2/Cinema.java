package cinemaRoomManager.stage_2;

import java.util.Scanner;

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

    private void print_seats(int num_rows, int num_seats_in_row) {
        System.out.println("Cinema:");
        // цикл по строчкам
        for (int i = 0; i < num_rows + 1; i++) {
            // цикл по столбцам
            for (int j = 0; j < num_seats_in_row + 1; j++) {
                if (i == 0) {
                    if (j == 0)
                        System.out.print(" ");
                    else
                        System.out.print(j);
                } else {
                    if (j == 0)
                        System.out.print(i);
                    else
                        System.out.print("S");
                }
                if (j + 1 != num_seats_in_row + 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
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
//        cinema.print_seats(num_rows, num_seats_in_row);
    }
}
