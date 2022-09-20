package module9turista;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;

    public Utente(String nome, String cognome, String email, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.indirizzo = indirizzo;
    }

    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getEmail() { return email; }
    public String getIndirizzo() { return indirizzo; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public void setEmail(String email) { this.email = email; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }

}
