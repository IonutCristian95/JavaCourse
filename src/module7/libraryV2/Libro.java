package module7.libraryV2;

public class Libro {
    private String codice;
    private String titolo;
    private String sinossi;
    private Autore autore;

    public Libro(String codice, String titolo, String sinossi, Autore autore) {
        this.codice = codice;
        this.titolo = titolo;
        this.sinossi = sinossi;
        this.autore = autore;
    }

    public String getCodice() { return codice; }
    public String getTitolo() { return titolo; }
    public Autore getAutore() { return autore; }
    public String getSinossi() { return sinossi; }
}
