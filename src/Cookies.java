import java.io.*;
import java.util.*;

public class Cookies {
    public static String[] mostActiveCookie(String filename, String date) throws Exception {
        String line = "";
        String splitBy = ",";
        Map<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while ((line = br.readLine()) != null) {

            String[] cookie = line.split(splitBy);
            if (cookie[1].contains(date)) {
                String currcookie = cookie[0];
                if (!map.containsKey(currcookie)) {
                    map.put(currcookie, 0);
                }
                map.put(currcookie, map.get(currcookie) + 1);
            }
        }
        Integer maxValue = null;
        ArrayList<String> maxKey = new ArrayList<>();
        for (String k : map.keySet()) {
            if (maxValue == null || map.get(k) >= maxValue) {

                maxValue = map.get(k);
                maxKey.add(k);
            }
        }
        return maxKey.toArray(new String[0]);
    }

    public static void main(String[] args){
        if (args.length < 3 || !args[1].equals("-d")){
            System.out.println("Usage: java Cookies <csv-file-name> -d <date>");
            return;
        }

        try {
            String[] s = mostActiveCookie(args[0], args[2]);
            for (String i : s) {
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.printf("An Exception is encountered: %s\n", e.toString());
        }
    }
}