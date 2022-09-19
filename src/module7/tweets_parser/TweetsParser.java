package module7.tweets_parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TweetsParser {
    public static void main(String[] args) {
        Path pathToFile = Paths.get("C:\\Users\\Heinrich\\Desktop\\JavaProjects\\testProgetto\\src\\module7\\tweets_parser\\realdonaldtrump.csv");
        Map<String, Integer> wordsMap = new HashMap<>();

        try (BufferedReader br = Files.newBufferedReader(pathToFile)){
            br.readLine(); //Get rid of the first row in the document : id, link, content, date, retweets, favorites, mentions, hashtags
            String[] tempString;
            String line;

            while(br.ready()){
                line = br.readLine().split(",")[2];
                line = line.replaceAll("[^a-zA-Z]|(http://*/\\S*)", " ");
                tempString = line.split(" ");

                for (String s : tempString) {
                    if (s.isEmpty() || s.isBlank()) continue;
                    if (!wordsMap.containsKey(s)){
                        wordsMap.put(s, 1);
                    }else{
                        wordsMap.put(s, (wordsMap.get(s)+1));
                    }
                }
            }

            List<Map.Entry<String, Integer>> tempHashset = new ArrayList<>(wordsMap.entrySet());

            tempHashset.sort(new Comparator<>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            for (Map.Entry<String, Integer> stringIntegerEntry : tempHashset) {
                System.out.println(stringIntegerEntry.getKey() + " : " + stringIntegerEntry.getValue());
            }

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
