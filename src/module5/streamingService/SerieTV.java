package module5.streamingService;

public class SerieTV extends ProdottoCatalogo{

    private int stagioni;
    private int episodiPerStagione;


    public SerieTV(String titolo, int anno, Genere genere, String pg, boolean originale, int stagioni, int episodiPerStagione) {
        super(titolo, anno, genere, pg, originale);
        this.stagioni = stagioni;
        this.episodiPerStagione = episodiPerStagione;
    }

    @Override
    public String toString() {
        return "SerieTV: " + super.getTitolo() + " Anno: " + super.getAnno() + " Genere: " + super.getGenere() +
                "\nOriginale: " + super.isOriginale() + " PG: " + super.getPg() + " Stagioni: " + this.getStagioni() +
                " Episodi per Stagione: " + this.getEpisodiPerStagione() + " Valutazione: " + super.getValutazione();
    }

    public int getStagioni() {
        return stagioni;
    }

    public void setStagioni(int stagioni) {
        if(stagioni > 0){
            this.stagioni = stagioni;
        }
    }

    public int getEpisodiPerStagione() {
        return episodiPerStagione;
    }

    public void setEpisodiPerStagione(int episodiPerStagione) {
        if(episodiPerStagione > 0){
            this.episodiPerStagione = episodiPerStagione;
        }
    }
}
