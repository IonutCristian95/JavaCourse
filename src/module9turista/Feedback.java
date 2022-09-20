package module9turista;

public class Feedback {
    private String id;
    private String titolo;
    private String testo;
    private int punteggio;

    public Feedback(String id, String titolo, String testo, int punteggio) {
        this.id = id;
        this.titolo = titolo;
        this.testo = testo;
        setPunteggio(punteggio);
    }

    public String getId() { return id; }
    public String getTitolo() { return titolo; }
    public String getTesto() { return testo; }
    public int getPunteggio() { return punteggio; }

    public void setPunteggio(int punteggio) {
        if(punteggio > 0 && punteggio <= 5){
            this.punteggio = punteggio;
        }
    }
}
