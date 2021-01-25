package simplyChattyBot.stage5;

import java.util.Scanner;

public class SignOfNumber {
    public static int sign(int number) {
        if (number >= 0) {
            if (number > 0) {
                return (1);
            } else {
                return (0);
            }
        } else {
            return(-1);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(sign(n));
    }
}
