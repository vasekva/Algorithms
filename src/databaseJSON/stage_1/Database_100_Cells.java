package databaseJSON.stage_1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database_100_Cells {
    private static String[] dataBaseArray;

    private static String[] init_array() {
        String[] array = new String[100];

        for (int i = 0; i < 100; i++) {
            array[i] = "";
        }
        return array;
    }

    private static void getCellFromArray(int index) {
        if (index < 1 || index > dataBaseArray.length
                || dataBaseArray[index - 1].isEmpty()) {
            System.out.println("ERROR");
        } else {
            System.out.println(dataBaseArray[index - 1]);
        }
    }

    private static void setCellInArray(int index, String str) {
        if (index < 1 || index > dataBaseArray.length) {
            System.out.println("ERROR");
        } else {
            dataBaseArray[index - 1] = str;
            System.out.println("OK");
        }
    }

    private static void deleteCellFromArray(int index)
    {
        if (index < 1 || index > dataBaseArray.length) {
            System.out.println("ERROR");
        } else {
            dataBaseArray[index - 1] = "";
            System.out.println("OK");
        }
    }

    /*
    *
    * */

    public static void main(String[] args) {
        String[] userInput;
        Pattern num = Pattern.compile("\\s\\d*");

        dataBaseArray = init_array();
        try (Scanner scanner = new Scanner(System.in)) {
            String str;
            String action;
            int    index_of_cell;

             while (true) {
                str = scanner.nextLine().replaceAll("[\\s]{2,}", " ").trim();
                Matcher matcher = num.matcher(str);
                matcher.find();

                userInput = str.split(" ");
                if (userInput[0].equals("exit"))
                    return;
                if (userInput.length >= 3) {
                    userInput = new String[3];
                    userInput[0] = str.replaceAll("\\s.*", "");
                    userInput[1] = matcher.group().trim();
                    userInput[2] = str.replaceAll("\\D*\\s\\d*\\s", "");
                    //System.out.println(userInput[3]);
                }
                if (userInput.length < 2)
                    System.out.println("ERROR");
                action = userInput[0];
                index_of_cell = 0;

                try {
                    index_of_cell = Integer.parseInt(userInput[1]);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR");
                }
                if (!(action.equals("get") || action.equals("set")
                        || action.equals("delete")))
                    throw new IllegalArgumentException();
                switch (action) {
                    case "get":
                        getCellFromArray(index_of_cell);
                        break;
                    case "set":
                        if (userInput.length < 3) {
                            System.out.println("ERROR");
                        } else {
                            setCellInArray(index_of_cell, userInput[2]);
                        }
                        break;
                    case "delete":
                        deleteCellFromArray(index_of_cell);
                        break;
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Wrong action!");
        }
    }
}
