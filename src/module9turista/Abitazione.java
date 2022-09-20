package module9turista;

public class Abitazione {
    /**
     * Ogni abitazione ha id, nome, indirizzo, numero di locali, numero di posti letto e piano.
     */
    private String id;
    private String indirizzo;
    private int numeroLocali;
    private int numeroPostiLetto;
    private int piano;

    public Abitazione(String id, String indirizzo, int numeroLocali, int numeroPostiLetto, int piano) {
        this.id = id;
        this.indirizzo = indirizzo;
        this.numeroLocali = numeroLocali;
        this.numeroPostiLetto = numeroPostiLetto;
        this.piano = piano;
    }

    public String getId() { return id; }
    public String getIndirizzo() { return indirizzo; }
    public int getNumeroLocali() { return numeroLocali; }
    public int getNumeroPostiLetto() { return numeroPostiLetto; }
    public int getPiano() { return piano; }
}
