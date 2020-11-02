package multiDimensionalArray;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfNeighbors {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> lines = new ArrayList<>();

        String s;
        while (!(s = reader.readLine()).equals("end")) {
            lines.add(Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray());

        }

        System.out.println("\n-----------------ИЗНАЧАЛЬНЫЙ МАССИВ-----------------\n");

        for (int[] nums: lines) {
            for (int num: nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < lines.size(); i++) {
            int[] str = lines.get(i); // строка в двумерном массиве
            int numRes = 0;

            for (int j = 0; j < str.length; j++) {
                // если попалась самая первая(верхняя) строка
                if (i == 0) {
                    // если элемент первый в строке
                    if (j == 0) {
                        //int[] array = lines.get(lines.size() - 1); // создаем массив интов последней строки списка
                        // находим сумму нижнего левого, нижнего(от элемента), самого правого и правого(от элемента) чисел
                        numRes = lines.get(lines.size() - 1)[j] + lines.get(i + 1)[j] + str[str.length - 1] + str[j + 1];
                        lines.get(i)[j] = numRes;
                    }
                    else {
                        // если элемент последний в строке
                        if (j == str.length - 1) {
                            // находим сумму нижнего правого, нижнего(от элемента), левого(от элемента) и самого левого чисел
                            numRes = lines.get(lines.size() - 1)[j] + lines.get(i + 1)[j] + str[j - 1] + str[0];
                            lines.get(i)[j] = numRes;
                        }
                        // иначе суммируем самый нижний, нижний, левый и правый элементы
                        else {
                            numRes = lines.get(lines.size() - 1)[j] + lines.get(i + 1)[j] + str[j - 1] + str[j + 1];
                            lines.get(i)[j] = numRes;
                        }
                    }
                }
                // если не первая строка
                else {
                    // если попалась самая последняя(нижняя) строка
                    if (i == str.length - 1) {
                        // если элемент первый в строке
                        if (j == 0) {
                            //int[] array = lines.get(lines.size() - 1); // создаем массив интов последней строки списка
                            // находим сумму верхнего(от элемента), самого верхнего, самого правого и правого(от элемента) чисел
                            numRes = lines.get(i - 1)[j] + lines.get(0)[j] + str[str.length - 1] + str[j + 1];
                            lines.get(i)[j] = numRes;
                        }
                        else {
                            // если элемент последний в строке
                            if (j == str.length - 1) {
                                // находим сумму верхнего(от элемента), самого верхнего, левого(от элемента) и самого левого чисел
                                numRes = lines.get(i - 1)[j] + lines.get(0)[j] + str[j - 1] + str[0];
                                lines.get(i)[j] = numRes;
                            }
                            // иначе суммируем верхний, самый верхний, левый и правый элементы
                            else {
                                numRes = lines.get(i - 1)[j] + lines.get(0)[j] + str[j - 1] + str[j + 1];
                                lines.get(i)[j] = numRes;
                            }
                        }
                    }
                    else {
                        // если элемент первый в строке
                        if (j == 0) {
                            // находим сумму верхнего(от элемента), нижнего(от элемента), самого правого и правого(от элемента) чисел
                            numRes = lines.get(i - 1)[j] + lines.get(i + 1)[j] + str[str.length - 1] + str[j + 1];
                            lines.get(i)[j] = numRes;
                        } else {
                            // если элемент последний в строке
                            if (j == str.length - 1) {
                                // находим сумму верхнего(от элемента), нижнего(от элемента), левого(от элемента) и самого левого чисел
                                numRes = lines.get(i - 1)[j] + lines.get(i + 1)[j] + str[j - 1] + str[0];
                                lines.get(i)[j] = numRes;
                            } else {
                                // находим сумму верхнего, нижнего, левого и правого чисел
                                numRes = lines.get(i - 1)[j] + lines.get(i + 1)[j] + str[j - 1] + str[j + 1];
                                lines.get(i)[j] = numRes;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("\n-----------------ФИНАЛЬНЫЙ МАССИВ-----------------\n");

        for (int[] nums1: lines) {
            for (int num1: nums1) {
                System.out.print(num1 + " ");
            }
            System.out.println();
        }

        //System.out.println(lines.get(0).toString());
//        for (int[] s: lines) {
//            for (int num: s) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }

        reader.close();
    }
}
