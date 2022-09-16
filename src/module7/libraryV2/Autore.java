package module7.libraryV2;

public class Autore {
    private String nome;
    private String cognome;

    public Autore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public boolean equals(Object obj) {
        Autore objAutore = (Autore) obj;
        return this.nome.equals(objAutore.nome) && this.cognome.equals(objAutore.cognome);
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}
