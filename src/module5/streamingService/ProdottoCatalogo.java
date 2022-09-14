package module5.streamingService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public abstract class ProdottoCatalogo {
    private String titolo;
    private int anno;
    private HashSet<String> cast;
    private Genere genere;
    private String pg;
    private boolean originale;
    private Hashtable<Utente, Integer> valutazione;
    private int preferredCounter;


    public ProdottoCatalogo(String titolo, int anno, Genere genere, String pg, boolean originale) {
        this.titolo = titolo;
        this.anno = anno;
        this.cast = new HashSet<>();
        this.genere = genere;
        this.pg = pg;
        this.originale = originale;
        this.valutazione = new Hashtable<>();
        this.preferredCounter = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnno() {
        return anno;
    }

    public Genere getGenere() {
        return genere;
    }

    public String getPg() {
        return pg;
    }

    public boolean isOriginale() {
        return originale;
    }

    public void addCast(String castElement) {
        if (!castElement.equals(null)) {
            cast.add(castElement);
        }
    }

    public void printCast() {
        for (String element : cast) {
            System.out.println(element);
        }
    }

    public void setValutazione(Utente utente, int value) {
        if(value >= 1 && value <= 5){
            valutazione.put(utente, value);
        }
    }

    public void printValutazione(){
        for(Utente utente : valutazione.keySet()){
            System.out.println(utente.getNome() + " voted " + valutazione.get(utente));
        }
    }

    public int getValutazione() {
        int temp = 0;
        int counter = 0;
        int result = 0;
        try {
            for(Utente utente : valutazione.keySet()){
                temp += valutazione.get(utente);
                counter++;
            }
            result = ((int)temp/counter);
        }catch (ArithmeticException e){
            return 0;
        }

        return result;
    }

    public int getPreferredCounter() {
        return preferredCounter;
    }

    public void setPreferredCounter(int preferredCounter) {
        this.preferredCounter = preferredCounter;
    }

    public void increasePreferredCounter(){
        this.preferredCounter++;
    }

    public void decreasePreferredCounter(){
        this.preferredCounter--;
    }

    @Override
    public abstract String toString();
}