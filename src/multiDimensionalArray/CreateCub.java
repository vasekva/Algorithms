package multiDimensionalArray;

/*
* Нужно реализовать createCube метод.
* Он должен создать трехмерный массив 3x3x3 со следующим содержимым:
* {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
* {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
* {0, 1, 2}, {3, 4, 5}, {6, 7, 8}
*/

public class CreateCub {

    public static int[][][] createCube() {
        int[][][] cub;
        int size;
        int num;

        size = 3;
        num = 0;
        cub = new int[size][size][size];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cub[i][j][k] = num;
                    num++;
                }
            }
            num = 0;
        }
        return (cub);
    }

    public static void main(String[] args) {
        int[][][] cub = createCube();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(cub[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
