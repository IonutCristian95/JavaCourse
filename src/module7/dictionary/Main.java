package module7.dictionary;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.insertWord("ciao", "greeting at meeting");
        dictionary.insertWord("retina", "Rete, spesso elastica, indossata sopra i capelli lunghi per tenerli in posizione");
        dictionary.insertWord("retina", "La rètina è la membrana più interna del bulbo oculare");
        dictionary.insertWord("calcio", "sport di squadra");
        dictionary.insertWord("calcio", "elemento chimico");
        dictionary.insertWord("calcio", "colpo dato col piede");
        dictionary.insertWord("calcio", "comune di 5353 abitanti");
        dictionary.insertWord("calcio", "impugnatura del fucile");
        dictionary.insertWord("circuito", "circuito elettrico");
        dictionary.insertWord("circuito", "circuito chiuso dove si svolgono corse");

        dictionary.printDictionary();
        try{
            dictionary.addMeaning("ciao", "greeting at parting");
            dictionary.addMeaning("cane", "animale");
        }catch( CharacterNotFoundException cnfe){
            System.out.println(cnfe.getMessage());
        }catch( WordNotFoundException wnfe){
            System.out.println(wnfe.getMessage());
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }

        dictionary.printDictionary();
        dictionary.insertWord("cane", "animale");

        dictionary.printDictionary();
    }
}
