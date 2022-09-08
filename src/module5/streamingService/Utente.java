package module5.streamingService;

public class Utente {
    private String nome;
    private String urlAvatar;
    private TipoUtente tipoUtente;
    private String pin;


    public Utente(String nome, String urlAvatar, TipoUtente tipoUtente, String pin) {
        this.nome = nome;
        this.urlAvatar = urlAvatar;
        this.tipoUtente = tipoUtente;
        this.pin = pin;
    }

    public String getNome() {
        return nome;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public TipoUtente getTipoUtente() {
        return tipoUtente;
    }

    public String getPin() {
        return pin;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public void setTipoUtente(TipoUtente tipoUtente) {
        this.tipoUtente = tipoUtente;
    }
}
