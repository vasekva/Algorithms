package simplyChattyBot.stage5;

import java.util.Scanner;

public class MaxOfThreeNum {

    public static int getNumberOfMaxParam(int a, int b, int c) {
        if (b > a) {
            if (c > b)
                return 3;
            else
                return 2;
        }
        else if (a < c)
            return 3;
        else {
            return 1;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();

        System.out.println(getNumberOfMaxParam(a, b, c));
    }
}
