package simplyChattyBot._switch;

import java.util.Scanner;

public class SimpCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int firstSpace = str.indexOf(' ');
        Long num1 = Long.parseLong(str.substring(0, firstSpace));
        String operator = str.substring(firstSpace + 1, firstSpace + 2);
        Long num2 = Long.parseLong(str.substring(firstSpace + 3));

        if (num2 == 0) {
            System.out.println("Division by 0!");
        } else {
            switch (operator) {
                case "+":
                    System.out.println(num1 + num2);
                    break;
                case "-":
                    System.out.println(num1 - num2);
                    break;
                case "/":
                    System.out.println(num1 / num2);
                    break;
                case "*":
                    System.out.println(num1 * num2);
                    break;
                default:
                    System.out.println("Unknown operator");
                    break;
            }
        }
    }
}
