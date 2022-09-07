package module5.distributoreBevande;

public class Prodotto {
    private double prezzo;
    private String nomeProdotto;

    public Prodotto(String nomeProdotto, double prezzo) {
        this.nomeProdotto = nomeProdotto;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    @Override
    public String toString() {
        return this.nomeProdotto;
    }
}
