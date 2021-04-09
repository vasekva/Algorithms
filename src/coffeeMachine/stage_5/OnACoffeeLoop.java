package coffeeMachine.stage_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnACoffeeLoop {
    private static int money = 550;
    private static int mlOfWater = 400;
    private static int mlOfMilk = 540;
    private static int gOfCoffee = 120;
    private static int numOfCups = 9;

    private static void buy() {
        Scanner scanner = new Scanner(System.in);
        String action;

        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        action = scanner.nextLine();
        switch (action) {
            case "1":
                if (checkResources("espresso") == true) {
                    mlOfWater -= 250;
                    gOfCoffee -= 16;
                    money += 4;
                    numOfCups--;
                }
                break;
            case "2":
                if (checkResources("latte") == true) {
                    mlOfWater -= 350;
                    mlOfMilk -= 75;
                    gOfCoffee -= 20;
                    money += 7;
                    numOfCups--;
                }
                break;
            case "3":
                if (checkResources("cappuccino") == true) {
                    mlOfWater -= 200;
                    mlOfMilk -= 100;
                    gOfCoffee -= 12;
                    money += 6;
                    numOfCups--;
                }
                break;
            default:
                System.out.println();
                break;
        }
    }

    private static void fill() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWrite how many ml of water do you want to add:");
        mlOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        mlOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        gOfCoffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        numOfCups += scanner.nextInt();

        System.out.println();
    }

    private static void take() {
        System.out.println("\nI gave you $" + money + "\n");
        money = 0;
    }

    private static void printContentsOfMachine() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(mlOfWater + " of water");
        System.out.println(mlOfMilk + " of milk");
        System.out.println(gOfCoffee + " of coffee beans");
        System.out.println(numOfCups + " of disposable cups");
        if (money == 0) {
            System.out.println(money + " of money\n");
        } else {
            System.out.println("$" + money + " of money\n");
        }
    }

    private static boolean checkResources(String coffee) {
        Map<String, Integer> map = new HashMap<>();

        // 1 - water, 2 - milk, 3 - coffee, 4 - cups
        switch (coffee) {
            case "espresso":
                map.put("water", mlOfWater / 250);
                map.put("coffee", gOfCoffee / 16);
                break;
            case "latte":
                map.put("water", mlOfWater / 350);
                map.put("milk", mlOfMilk / 75);
                map.put("coffee", gOfCoffee / 20);
                break;
            case "cappuccino":
                map.put("water", mlOfWater / 200);
                map.put("milk", mlOfMilk / 100);
                map.put("coffee", gOfCoffee / 12);
                break;
        }
        for (Map.Entry<String, Integer> pair: map.entrySet()) {
            if (pair.getValue() == 0) {
                System.out.println("Sorry, not enough " + pair.getKey() + "!\n");
                return false;
            }
        }
        System.out.println("I have enough resources, making you a coffee!\n");
        return true;
    }
    public static void action(String actions) {
            switch (actions) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "remaining":
                    printContentsOfMachine();
                    break;
                case "take":
                    take();
                    break;
                case "exit":
                    return;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (; ;) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String actionS = scanner.nextLine();
            if (actionS.equals("exit")) {
                return;
            } else {
                action(actionS);
            }
        }
    }
}
