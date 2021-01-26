package multiDimensionalArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckSudoku {
    private static int[][] readMap() {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        if (num == 0 || num > 10) {
            return null;
        }
        int size = num * num;
        int[][] map = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] str = scanner.nextLine().split(" ");

            if (str.length != size) {
                return null;
            }
            for (int j = 0; j < str.length; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 0 || map[i][j] > size) {
                    return null;
                }
            }
        }
        return map;
    }

    private static int checkArrayInArray(Map<Integer, Integer> checkMap, int[][] map, int num, int size) {
        int countNums = 1;
        int countRow = 1;
        int countCol = 1;
        int i = 0;
        int j = 0;

        for (int count = 0; count < size; count++) { // цикл на обход массивов размером num * num
            for (int countJ = 0; countJ < num; countJ++) { // цикл переключения j (строчки)
                for (int countI = 0; countI < num; countI++) { // цикл переключения i (колонки)
                    for (Map.Entry<Integer, Integer> pair : checkMap.entrySet()) {
                        if (pair.getKey() == map[j][i]) {
                            checkMap.put(pair.getKey(), pair.getValue() + 1);
                        }
                        if (pair.getValue() > countNums) {
                            return -1;
                        }
                    }
                    if (i == num * countCol - 1) { // если i == крайнему столбцу в колонне
                        if (j == num * countRow - 1) { // если j == крайней строке в ряду
                            if (i == num * num - 1) { // если i == крайнему столбцу в массиве
                                i = 0;
                                countRow++; // увеличиваем счетчик ряда
                                countCol = 1; // скручиваем счетчик колонны до самой первой
                            } else {
                                i++;
                                countCol++; // увеличиваем счетчик колонны
                            }
                        } else {
                            i = i - (num - 1); // передвигает i в самый первый столбец колонны
                        }
                    } else {
                        i++;
                    }
                }
                if (j == num * countRow - 1) { // если j == крайней строке в ряду
                    j = j - (num - 1); // передвигает j в самую первую (верхнюю) строку ряда
                } else {
                    j++;
                }
            }
            countNums++;
        }
        return 0;
    }

    private static int checkVerticalLines(Map<Integer, Integer> checkMap, int[][] map, int size) {
        for (int jVert = 0; jVert < size; jVert++) {
            for (int iVert = 0; iVert < size; iVert++) {
                for (Map.Entry<Integer, Integer> pair : checkMap.entrySet()) {
                    if (pair.getKey() == map[jVert][iVert]) {
                        checkMap.put(pair.getKey(), pair.getValue() + 1);
                    }
                    if (pair.getValue() > 1) {
                        return -1;
                    }
                }
            }
            for (int n = 1; n <= map.length; n++) {
                checkMap.put(n, 0);
            }
        }
        return 0;
    }

    private static int checkHorizontalLines(Map<Integer, Integer> checkMap, int[][] map, int size) {
        for (int jHor = 0; jHor < size; jHor++) {
            for (int iHor = 0; iHor < size; iHor++) {
                for (Map.Entry<Integer, Integer> pair : checkMap.entrySet()) {
                    if (pair.getKey() == map[iHor][jHor]) {
                        checkMap.put(pair.getKey(), pair.getValue() + 1);
                    }
                    if (pair.getValue() > 1) {
                        return -1;
                    }
                }
            }
            for (int n = 1; n <= map.length; n++) {
                checkMap.put(n, 0);
            }
        }
        return 0;
    }

    private static int checkMap(int[][] map) {
        Map<Integer, Integer> checkMap = new HashMap<>();
        int size = map.length;
        int num = (int) Math.sqrt(size);

        for (int number = 1; number <= map.length; number++) {
            checkMap.put(number, 0);
        }
        if (checkArrayInArray(checkMap, map, num, size) == -1) {
            return -1;
        }
        for (int n = 1; n <= map.length; n++) {
            checkMap.put(n, 0);
        }
        if (checkVerticalLines(checkMap, map, size) == -1) {
            return -1;
        }
        if (checkHorizontalLines(checkMap, map, size) == -1) {
            return -1;
        }
        return 1;
    }

    public static void main(String[] args)
    {
        int check_map;
        int[][] map;

        if ((map = readMap()) == null) {
            System.out.println("Ошибка чтения карты!");
            System.out.println("NO");
            return;
        }
        if ((check_map = checkMap(map)) == -1) {
            System.out.println("Вы неверно заполнили карту!");
            System.out.println("NO");
        } else {
            System.out.println("Поздравляю! Ваша карта верна!");
            System.out.println("YES");
        }
    }
}
