package recursion;

import java.util.Scanner;

/**
    Выводит кол-во комбинаций k-чисел из набора чисел n
    comb(3, 2) = 3
    (1, 2, 3)
    1, 2
    1, 3
    2, 3
 */
public class K_combination {
    public static int comb(int n, int k) {
        if (k > n)
            return (0);
        if (k == 0)
            return (1);
        return (comb(n - 1, k) + comb(n - 1, k - 1));
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        System.out.println(comb(n, k));
    }
}
