package simplyChattyBot.stage4;

import java.util.Scanner;

public class CheckTheValue {
    public static void main(String[] args) {
        int count;
        Scanner scanner = new Scanner(System.in);

        count = scanner.nextInt();
        if (count < 10) {
            System.out.println("true");
        } else
            System.out.println("false");
    }
}
