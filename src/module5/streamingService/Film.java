package module5.streamingService;

public class Film extends ProdottoCatalogo{
    public Film(String titolo, int anno, Genere genere, String pg, boolean originale) {
        super(titolo, anno, genere, pg, originale);
    }

    @Override
    public String toString() {
        return "Film: " + super.getTitolo() + " Anno: " + super.getAnno() + " Genere: " + super.getGenere() +
                "\nOriginale: " + super.isOriginale() + " PG: " + super.getPg() + " Valutazione: " + super.getValutazione();
    }
}
