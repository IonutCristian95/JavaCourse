package module9turista;

public class Host extends Utente {
    private String codiceHost;

    public Host(String nome, String cognome, String email, String indirizzo, String codiceHost) {
        super(nome, cognome, email, indirizzo);
        this.codiceHost = codiceHost;
    }

    public String getCodiceHost() { return codiceHost; }
}
