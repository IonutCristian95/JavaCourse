package module5.streamingService;

import java.util.ArrayList;
import java.util.List;

public abstract class ProdottoCatalogo {
    private String titolo;
    private int anno;
    private List<String> cast;
    private Genere genere;
    private String pg;
    private boolean originale;

    public ProdottoCatalogo(String titolo, int anno, Genere genere, String pg, boolean originale) {
        this.titolo = titolo;
        this.anno = anno;
        this.cast = new ArrayList<>();
        this.genere = genere;
        this.pg = pg;
        this.originale = originale;
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

    public void addCast(String castElement){
        if (!cast.equals(null)){
            cast.add(castElement);
        }
    }

    public void printCast(){
        for(String element : cast){
            System.out.println(element);
        }
    }

    @Override
    public abstract String toString();
}