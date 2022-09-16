package module7.dictionary;

public class CharacterNotFoundException extends Exception {
    public CharacterNotFoundException(Character c) {
        super("Character " + c + " not found.");
    }
}
