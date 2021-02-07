package simpleClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exceptions {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String str = reader.readLine().replaceAll("[\\s]{2,}", " ").trim();
        if (str.isEmpty())
        {
            System.out.println("0");
        } else {
            String words[] = str.split(" ");
            System.out.println(words.length);
        }
        reader.close();
    }
}

