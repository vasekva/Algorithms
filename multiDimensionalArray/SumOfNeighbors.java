package multiDimensionalArray;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfNeighbors {
    private static int numRes;
    private static List<int[]> lines = new ArrayList<>();
    private static List<int[]> resArray = new ArrayList<>();


    private static void printFirstLine(int j, int i, int[] str) {
        // если элемент первый в строке
        if (j == 0) {
            // находим сумму нижнего левого, нижнего(от элемента), самого правого и правого(от элемента) чисел
            numRes = lines.get(lines.size() - 1)[j] + lines.get(i + 1)[j] + str[str.length - 1] + str[j + 1];
            resArray.get(i)[j] = numRes;
        }
        else {
            // если элемент последний в строке
            if (j == str.length - 1) {
                // находим сумму нижнего правого, нижнего(от элемента), левого(от элемента) и самого левого чисел
                numRes = lines.get(lines.size() - 1)[j] + lines.get(i + 1)[j] + str[j - 1] + str[0];
                resArray.get(i)[j] = numRes;
            }
            // иначе суммируем самый нижний, нижний, левый и правый элементы
            else {
                numRes = lines.get(lines.size() - 1)[j] + lines.get(i + 1)[j] + str[j - 1] + str[j + 1];
                resArray.get(i)[j] = numRes;
            }
        }
    }

    private static void printLastLine(int j, int i, int[] str) {
        // если элемент первый в строке
        if (j == 0) {
            // находим сумму верхнего(от элемента), самого верхнего, самого правого и правого(от элемента) чисел
            numRes = lines.get(i - 1)[j] + lines.get(0)[j] + str[str.length - 1] + str[j + 1];
            resArray.get(i)[j] = numRes;
        }
        else {
            // если элемент последний в строке
            if (j == str.length - 1) {
                // находим сумму верхнего(от элемента), самого верхнего, левого(от элемента) и самого левого чисел
                numRes = lines.get(i - 1)[j] + lines.get(0)[j] + str[j - 1] + str[0];
                resArray.get(i)[j] = numRes;
            }
            // иначе суммируем верхний, самый верхний, левый и правый элементы
            else {
                numRes = lines.get(i - 1)[j] + lines.get(0)[j] + str[j - 1] + str[j + 1];
                resArray.get(i)[j] = numRes;
            }
        }
    }

    private static void printLines(int j, int i, int[] str) {
        // если элемент первый в строке
        if (j == 0) {
            // находим сумму верхнего(от элемента), нижнего(от элемента), самого правого и правого(от элемента) чисел
            numRes = lines.get(i - 1)[j] + lines.get(i + 1)[j] + str[str.length - 1] + str[j + 1];
            resArray.get(i)[j] = numRes;
        } else {
            // если элемент последний в строке
            if (j == str.length - 1) {
                // находим сумму верхнего(от элемента), нижнего(от элемента), левого(от элемента) и самого левого чисел
                numRes = lines.get(i - 1)[j] + lines.get(i + 1)[j] + str[j - 1] + str[0];
                resArray.get(i)[j] = numRes;
            } else {
                // находим сумму верхнего, нижнего, левого и правого чисел
                numRes = lines.get(i - 1)[j] + lines.get(i + 1)[j] + str[j - 1] + str[j + 1];
                resArray.get(i)[j] = numRes;
            }
        }
    }

    private static void print() {

        if (lines.get(0).length == 1) {
            System.out.println( (lines.get(0)[0] * 4));
            return;
        }

        System.out.println("\n-----------------ИЗНАЧАЛЬНЫЙ МАССИВ-----------------\n");

        for (int[] numsLines: lines) {
            for (int num: numsLines) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println("\n-----------------НУЖНЫЙ МАССИВ-----------------\n");
        for (int[] numsResArray1: resArray) {
            for (int num: numsResArray1) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < lines.size(); i++) {
            int[] str = lines.get(i); // строка в двумерном массиве
            numRes = 0;

            for (int j = 0; j < str.length; j++) {
                // если попалась самая первая(верхняя) строка
                if (i == 0) {
                    printFirstLine(j, i, str);
                } else {
                    // если попалась самая последняя(нижняя) строка
                    if (i == str.length - 1) {
                        printLastLine(j, i, str);
                    } else {
                        printLines(j, i, str);
                    }
                }
            }
        }

        System.out.println("\n-----------------ФИНАЛЬНЫЙ МАССИВ-----------------\n");

        for (int[] nums1: resArray) {
            for (int num1: nums1) {
                System.out.print(num1 + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        int i = 0;
        while (!(s = reader.readLine()).equals("end")) {
            lines.add(Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray());
            resArray.add(new int[lines.get(i++).length]);
        }
//        resArray.addAll(lines);
//        for (int[] numsResArray: resArray) {
//            for (int i = 0; i < numsResArray.length; i++) {
//                numsResArray[i] = 0;
//            }
//        }
        print();


        reader.close();
    }
}
