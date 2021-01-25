import java.util.Scanner;

public class ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        //productOfNumbers(a, b);
        System.out.println(sumInRange(a, b));

        //final long number = scanner.nextLong();
        //System.out.println(isComposite(number));
    }

    private static void productOfNumbers(int a, int b) {
        long res = 1;

        for (int i = a; i < b; i++) {
            res *= i;
            System.out.println(res);
        }
    }

    public static long sumInRange(int from, int to) {
        long res = 0;
        for (int i = from; i < to; i++) {
            res += i;
        }
        return res;
    }

    public static boolean isComposite(long number) {
        for (long i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }
}
