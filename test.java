import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        //int[] nums = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();

        switch (args[0])
        {
            case ("MAX"): max(parseStrToInt(args));
            break;
            case ("MIN"): min(parseStrToInt(args));
            break;
            case ("SUM"): sum(parseStrToInt(args));
            break;
        }
    }

    private static int[] parseStrToInt(String[] args) {
        int res[] = new int[args.length - 1];

        for (int i = 1; i < res.length; i++) {
            int num = Integer.parseInt(args[i]);
            res[i - 1] = num;
        }


        return res;
    }

    private static void max(int[] nums) {
        int res;

        res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res) {
                res = nums[i];
            }
        }

        System.out.println(res);
    }

    private static void min(int[] nums) {
        int res;

        res = nums[0];
        System.out.println(nums[nums.length]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < res) {
                res = nums[i];
            }
            System.out.println(res);
        }

        System.out.println(res);
    }

    private static void sum(int[] nums) {
        int res;

        res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }

        System.out.println(res);
    }
}
