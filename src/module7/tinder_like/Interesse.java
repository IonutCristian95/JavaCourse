package module7.tinder_like;

import java.util.Objects;

public class Interesse {
    private static int counter = 0;
    private String codice;
    private String testo;

    public Interesse(String testo) {
        this.codice = "I"+getCounter();
        this.testo = testo;
    }

    public String getTesto() {
        return testo;
    }

    public String getCodice() {
        return codice;
    }

    public static int getCounter() {
        return counter++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interesse interesse = (Interesse) o;
        return codice.equals(interesse.codice) &&
                testo.equals(interesse.testo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice, testo);
    }
}
