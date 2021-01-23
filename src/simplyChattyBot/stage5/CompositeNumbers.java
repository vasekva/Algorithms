package simplyChattyBot.stage5;

import java.util.Scanner;

public class CompositeNumbers {
    public static boolean isComposite(long number) {
        int i = 2;
        int count = 0;

        if (number < 4) {
            return false;
        } else {
            while (i != number) {
                if (number % i == 0) {
                    count++;
                }
                i++;
            }
            if (count != 0) {
                return true;
            }
        }
        return false;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long number = scanner.nextLong();
        System.out.println(isComposite(number));
    }
}
