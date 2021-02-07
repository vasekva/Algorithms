package simpleClasses;

import java.util.regex.*;

public class test {

    public static void main(String[] args) {

        String str = "      delete     1 Hello    World world";
        String second;

        Pattern num = Pattern.compile("\\s\\d*");
        Matcher matcher = num.matcher(str);
        matcher.find();

        String first = str.replaceAll("\\s.*", "");
        second = matcher.group().trim();
        String third = str.replaceAll("\\D*\\d\\s", "");

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

    public static String[] sortArray(String[] array) {
        java.util.Arrays.sort(array);
        return array;
    }

}
