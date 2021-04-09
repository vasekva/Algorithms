package coffeeMachine.stage2;

import java.util.Scanner;

public class MachinesHaveNeeds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        int mlOfWater;
        int mlOfMilk;
        int gOfCoffee;

        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

        System.out.println("Write how many cups of coffee you will need:");
        count = scanner.nextInt();
        mlOfWater = count * 200;
        mlOfMilk = count * 50;
        gOfCoffee = count * 15;

        System.out.println("For " + count + " cups of coffee you will need:");
        System.out.println(mlOfWater + " ml of water");
        System.out.println(mlOfMilk + " ml of milk");
        System.out.println(gOfCoffee + " g of coffee beans");
    }
}
