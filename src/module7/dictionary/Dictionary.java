package module7.dictionary;
import java.util.HashSet;
import java.util.TreeMap;

public class Dictionary {
    private TreeMap<Character, TreeMap<String, HashSet<String>>> dictionary;

    public Dictionary() {
        this.dictionary = new TreeMap<>();
    }

    public void insertWord(String word, String meanings){
        if(word.isEmpty() || meanings.isEmpty() || meanings==null){
            return;
        }
        word = word.toLowerCase();
        Character firstChar= word.charAt(0);
        HashSet<String> tempMeanings = new HashSet<>();
        TreeMap<String, HashSet<String>> tempDictionary = new TreeMap<>();
        if(dictionary.containsKey(firstChar)){
            tempDictionary = dictionary.get(firstChar);
            if(tempDictionary.containsKey(word)) {
                tempMeanings = tempDictionary.get(word);
            }
        }
        tempMeanings.add(meanings);
        tempDictionary.put(word, tempMeanings);
        dictionary.put(firstChar, tempDictionary);
    }

    public void addMeaning(String word, String meaning) throws CharacterNotFoundException, WordNotFoundException {
        if(word==null || word.isEmpty()){
            return;
        }
        Character firstChar= word.charAt(0);
        HashSet<String> tempMeanings;
        if (dictionary.containsKey(firstChar)){
            tempMeanings = dictionary.get(firstChar).getOrDefault(word, null);
            if (tempMeanings==null){
                throw new WordNotFoundException(word);
            }
            tempMeanings.add(meaning);
            dictionary.get(firstChar).put(word, tempMeanings);
        }else{
            throw new CharacterNotFoundException(firstChar);
        }

    }

    public void printDictionary(){
        for(Character character : dictionary.keySet()){
            System.out.print(character + ":[");
            TreeMap<String, HashSet<String>> currentValue = dictionary.get(character);
            for (String word : currentValue.keySet()) {
                System.out.print(word + ": (");
                HashSet<String> meanings = currentValue.get(word);
                meanings.forEach((String s1) -> System.out.print(s1+";"));
                System.out.print("), ");
            }
            System.out.println("]");
        }
    }

}