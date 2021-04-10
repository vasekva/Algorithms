package multiDimensionalArray;

/*
* Реализовать printCorners метод.
* Он должен напечатать все угловые элементы twoDimArray
* в следующем порядке: слева направо и сверху вниз.
* Элементы должны быть разделены пробелом
*/

public class PrintCorners {

    public static void printCorners(int[][] twoDimArray) {
        int width;
        int hight;

        width = twoDimArray[0].length - 1;
        hight = twoDimArray.length - 1;
        System.out.println(twoDimArray[0][0] + " " + twoDimArray[0][width]);
        System.out.println(twoDimArray[hight][0] + " " + twoDimArray[hight][width]);
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};

        printCorners(array);
    }
}
