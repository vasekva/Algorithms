package coffeeMachine.stage_3;

import java.util.Scanner;

public class EnoughCoffeeForEveryone {
    private static int min(int water, int milk, int gOfCoffee) {
        int waterInCup = 200;
        int milkInCup = 50;
        int gOfCoffeeInCup = 15;

        int min = Math.min(Math.min(water / waterInCup, milk / milkInCup), gOfCoffee / gOfCoffeeInCup);

        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        int mlOfWater;
        int mlOfMilk;
        int gOfCoffee;
        int countOfCoffeeHas;

        System.out.println("Write how many ml of water the coffee machine has:");
        mlOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        mlOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        gOfCoffee = scanner.nextInt();
        countOfCoffeeHas = min(mlOfWater, mlOfMilk, gOfCoffee);

        System.out.println("Write how many cups of coffee you will need:");
        count = scanner.nextInt();
        if (count <= countOfCoffeeHas) {
            if (count == countOfCoffeeHas) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee (and even " + (countOfCoffeeHas - count) +
                        " more than that)");
            }
        } else {
            System.out.println("No, I can make only " + countOfCoffeeHas + " cup(s) of coffee");
        }
    }
}
