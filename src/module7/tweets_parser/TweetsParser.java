package module7.tweets_parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TweetsParser {
    public static void main(String[] args) {
        Path pathToFile = Paths.get("src\\module7\\tweets_parser\\resources\\realdonaldtrump.csv");
        Path pathToStopWords = Paths.get("src\\module7\\tweets_parser\\resources\\english_stopwords.txt");
        Map<String, Integer> wordsMap = new HashMap<>();
        HashSet<String> stopWords = new HashSet<>();

        //Get the stopwords
        getStopWords(stopWords, pathToStopWords);


        try (BufferedReader br = Files.newBufferedReader(pathToFile)){
            br.readLine(); //Get rid of the first row in the document : id, link, content, date, retweets, favorites, mentions, hashtags
            String[] tempString;
            String line;

            while(br.ready()){
                line = br.readLine().split(",")[2];
                line = line.replaceAll("[^a-zA-Z]|(http://*/\\S*)", " ");
                tempString = line.split(" ");

                for (String s : tempString) {
                    if (s.isEmpty() || s.isBlank() || stopWords.contains(s.toLowerCase())) continue;
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

    private static void getStopWords(HashSet<String> temp, Path pathToStopWordsFile){
        try (BufferedReader br2 = Files.newBufferedReader(pathToStopWordsFile)){
            while (br2.ready()){
                temp.add(br2.readLine().strip());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
