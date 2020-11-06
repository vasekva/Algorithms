package multiDimensionalArray;

import java.util.*;

public class CheckSudoku {
    //private static List<ArrayList<Integer>> nums = new ArrayList<>();
    private static Map<Integer, Integer> letters = new HashMap<>();
    private static int count = 0;
    private static int numOfSize;
    private static int[][] matrix;
    private static int size;



    private static boolean checkValueForRules() {

        //!!!!!!!!!!!!!!!!!
        // TODO проверить что матрица как минимум 2*2


            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int tempNum = matrix[i][j];
                    if (!letters.containsKey(tempNum)) {
                        letters.put(tempNum, 1);
                    } else {
                        letters.put(tempNum, letters.get(tempNum) + 1);
                    }
                }
            }

        //TODO попытка чтения матрицы квадратами 2 на 2 в 4 шага
        int count = 0;
            // цикл по кол-вам шагов по матрице
        for (int num = 0; num < (size * size) / 4; num++) {
            // цикл для i матрицы[i][j]
            for (int i = 0; i < size - 1; i++) {
                // цикл для j матрицы[i][j]
                for (int j = 0; j < size - 1; j++) {
                    System.out.println(matrix[i][j] + " ");
                    if ((j + 1) % 2 == 0) {
                        j = 0;
                        i = i + 1;
                    }
                    if (count == 4) {
                        i = i - 1;
                        j = j + 1;
                    }
                }
                System.out.println();
            }
        }

        return true;
    }

//    private static void printMatrix() {
//        System.out.println("-----ТВОЯ МАТРИЦА-----");
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    private static int checkValueMap() {
        int countChars = 0;

        for (Map.Entry<Integer, Integer> entry : letters.entrySet()) {
            if (entry.getValue() > 1) {
                countChars = entry.getValue();


                count = entry.getValue();
            }
        }
        return countChars;
    }

    private static void clearMap() {
        letters.clear();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;

        numOfSize = scanner.nextInt();
        size = numOfSize * numOfSize;
        matrix = new int[size][size];

        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] == 0 || matrix[i][j] > size) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        checkValueForRules();

//        printMatrix();
//
//        if (!checkValueForRules()) {
//            System.out.println("NO");
//            return;
//        }

        // чтение столбцов массива
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int tempNum = matrix[j][i];

                if (!letters.containsKey(tempNum)) {
                    letters.put(tempNum, 1);
                } else {
                    letters.put(tempNum, letters.get(tempNum) + 1);
                }
            }

            if (checkValueMap() != 0) {
                System.out.println("NO");
                return;
            } else {
                clearMap();
            }
        }
        if (count == 0) {
            System.out.println("YES");
            return;
        }
    }
}
