package module7.dictionary;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        ArrayList<String> tempMeanings = new ArrayList<>();
        tempMeanings.add("Greeting");
        dictionary.insertWord("Ciao", tempMeanings);
        tempMeanings.clear();

        dictionary.printDictionary();
    }
}
