package CoffeeMachine.stage4;

import java.util.Scanner;

public class Action {
    private static int money = 550;
    private static int mlOfWater = 400;
    private static int mlOfMilk = 540;
    private static int gOfCoffee = 120;
    private static int numOfCups = 9;

    private static void buy() {
        Scanner scanner = new Scanner(System.in);
        int action;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        action = scanner.nextInt();
        switch (action) {
            case 1:
                mlOfWater -= 250;
                gOfCoffee -= 16;
                money += 4;
                numOfCups--;
                break;
            case 2:
                mlOfWater -= 350;
                mlOfMilk -= 75;
                gOfCoffee -= 20;
                money += 7;
                numOfCups--;
                break;
            case 3:
                mlOfWater -= 200;
                mlOfMilk -= 100;
                gOfCoffee -= 12;
                money += 6;
                numOfCups--;
                break;
        }
    }

    private static void fill() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water do you want to add:");
        mlOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        mlOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        gOfCoffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        numOfCups += scanner.nextInt();
    }

    private static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("The coffee machine has:");
        System.out.println(mlOfWater + " of water");
        System.out.println(mlOfMilk + " of milk");
        System.out.println(gOfCoffee + " of coffee beans");
        System.out.println(numOfCups + " of disposable cups");
        System.out.println(money + " of money\n");

        System.out.println("Write action(buy, fill, take)");
        String action = scanner.nextLine();

        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
        }

        System.out.println("\nThe coffee machine has:");
        System.out.println(mlOfWater + " of water");
        System.out.println(mlOfMilk + " of milk");
        System.out.println(gOfCoffee + " of coffee beans");
        System.out.println(numOfCups + " of disposable cups");
        System.out.println(money + " of money\n");
    }
}
