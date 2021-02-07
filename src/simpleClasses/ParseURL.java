package simpleClasses;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseURL {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        String url = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\w+\\=\\w+|\\w+\\=&");
        Matcher matcher = pattern.matcher(url);

        while (matcher.find()) {
            String[] str = (url.substring(matcher.start(), matcher.end())).split("=");
            map.put(str[0], str[1]);
        }

        String pass = "temp";
        for (Map.Entry<String, String> pairs: map.entrySet()) {
            if ("pass".equals(pairs.getKey())) {
                pass = pairs.getValue();
            }
        }
        if (!pass.equals("temp")) {
            map.put("password", pass);
        }
        for (Map.Entry<String, String> pairs: map.entrySet()) {
            if (pairs.getValue().equals("&")) {
                map.put(pairs.getKey(), "not found");
            }
            System.out.println(pairs.getKey() + " : " + pairs.getValue());
        }
    }
}
