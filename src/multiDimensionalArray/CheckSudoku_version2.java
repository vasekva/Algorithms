package multiDimensionalArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckSudoku_version2 {

    private static int[][] read_map()
    {
        Scanner scanner = new Scanner(System.in);
        int size;
        int num = Integer.parseInt(scanner.nextLine());

        size = num * num;

        int[][] map = new int[size][size];

        for (int i = 0; i < size; i++)
        {
            String[] str = scanner.nextLine().split(" ");
            if (str.length != size)
            {
                System.out.println("Кол-во cимволов в строке не верно!");
                return null;
            }
            for (int j = 0; j < str.length; j++)
            {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 0 || map[i][j] > size)
                {
                    System.out.println("Вы не можете использовать число " + map[i][j] + "!");
                    return null;
                }
            }
        }
//        for (int i = 0; i < size; i++)
//        {
//            for (int j = 0; j < size; j++)
//            {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        return map;
    }

    private static int check_map(int[][] map)
    {
        Map<Integer, Integer> checkMap = new HashMap<>();

        for (int i = 1; i <= map.length; i++)
        {
            checkMap.put(i, 0);
        }
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map.length; j++)
            {
                for (Map.Entry<Integer, Integer> pair : checkMap.entrySet())
                {
                    if (pair.getKey() == map[j][i])
                    {
                        checkMap.put(pair.getKey(), pair.getValue() + 1);
                    }
                }
            }
        }
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map.length; j++)
            {
                int num = map[0][j];
            }
        }
        for (Map.Entry<Integer, Integer> pair : checkMap.entrySet())
        {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        return (0);
    }

    public static void main(String[] args)
    {
        int[][] map = read_map();
        if (map == null)
        {
            System.out.println("Ошибка чтения карты!");
        }
        int check = check_map(map);
    }
}
