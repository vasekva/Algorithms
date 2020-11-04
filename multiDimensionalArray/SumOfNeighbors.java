package multiDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfNeighbors {
    private static List<int[]> lines = new ArrayList<>();
    private static List<int[]> resArray = new ArrayList<>();

    private static void print() {

        for (int i = 0; i < lines.size(); i++) {
            int strLen = lines.get(i).length;

            for (int j = 0; j < strLen; j++) {
                int[] str = lines.get(i);

                // если у элемента нет соседа слева
                if (j == 0) {
                    resArray.get(i)[j] = str[str.length - 1]; // получаем самый правый элемент
                } else {
                    resArray.get(i)[j] = str[j - 1]; // получаем элемент левее
                }
                // если у элемента нет соседа справа
                if (j == str.length - 1) {
                    resArray.get(i)[j] += str[0]; // получаем самый левый элемент
                } else {
                    resArray.get(i)[j] += str[j + 1]; // получаем элемент правее
                }
                // если у элемента нет соседа снизу
                if (i == lines.size() - 1) {
                    resArray.get(i)[j] += lines.get(0)[j]; // получаем самый верхний элемент над ним
                } else {
                    resArray.get(i)[j] += lines.get(i + 1)[j]; // получаем элемент под ним
                }
                // если у элемента нет соседа сверху
                if (i == 0) {
                    resArray.get(i)[j] += lines.get(lines.size() - 1)[j]; // получаем самый нижний элемент под ним
                } else {
                    resArray.get(i)[j] += lines.get(i - 1)[j]; // получаем элемент нам ним
                }
            }
        }

        for (int[] nums1: resArray) {
            for (int num1: nums1) {
                System.out.print(num1 + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int i;
        String s;

        i = 0;
        while (!(s = reader.readLine()).equals("end")) {
            lines.add(Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray());
            resArray.add(new int[lines.get(i++).length]);
        }

        print();

        reader.close();
    }
}
