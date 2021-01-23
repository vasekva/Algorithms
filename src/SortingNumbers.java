import java.util.Scanner;

public class SortingNumbers {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuffer sb = new StringBuffer(s);

        System.out.println(s.length());

        if (s.length() % 2 == 0) {
            int index1 = s.length() / 2;
            int index2 = index1--;
            System.out.printf("%d %d\n", index1, index2);
            sb.delete(index1, index2 + 1);
        } else {
            int index = s.length() / 2;
            sb.delete(index, index + 1);
        }
        System.out.println(sb);
    }
}
