package recursion;

import java.util.Scanner;

public class Pow {
    public static double pow(double a, long n) {
        if (a == 0)
            return (0);
        if (n == 0) {
            return (1);
        }
        if (n % 2 == 1) {
            return a * pow(a, n - 1);
        } else {
            return pow(a * a, n / 2);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final double a = Double.parseDouble(scanner.nextLine());
        final int n = Integer.parseInt(scanner.nextLine());
        System.out.println(pow(a, n));
    }
}
