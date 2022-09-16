package module7.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

public class Dictionary {
    private TreeMap<Character, TreeMap<String, HashSet<String>>> dictionary;

    public Dictionary() {
        this.dictionary = new TreeMap<>();
    }

    public void insertWord(String word, ArrayList<String> meanings){
        word = word.toLowerCase();
        Character firstChar= word.charAt(0);

        TreeMap<String, HashSet<String>> tempDictionary = dictionary.get(firstChar);

        HashSet<String> tempMeanings = tempDictionary.get(word);
        tempMeanings.addAll(meanings);

        tempDictionary.put(word, tempMeanings);

        dictionary.put(firstChar, tempDictionary);
    }

    public void printDictionary(){
        for(Character character : dictionary.keySet()){
            System.out.print(character + ":[");
            TreeMap<String, HashSet<String>> currentValue = dictionary.get(character);
            for (String word : currentValue.keySet()) {
                System.out.print(word + ":");
                HashSet<String> meanings = currentValue.get(word);
                System.out.print(Arrays.asList(meanings.toArray()));
            }
            System.out.println("]");
        }
    }

    public void addMeaning(String word){
    }

}