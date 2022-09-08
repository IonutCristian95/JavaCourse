package module5.serieA;

public class Giocatore {
    private int id;
    private String nome;
    private String cognome;

    public Giocatore(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " Nome: " + this.nome + " Cognome: " + this.cognome;
    }

}
