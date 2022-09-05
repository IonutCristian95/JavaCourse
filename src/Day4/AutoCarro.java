package Day4;

public class AutoCarro extends Veicolo{
    private int capacitaMassima;

    public AutoCarro(String targa, int numeroPosti, int capacitaMassima) {
        super(targa, numeroPosti);
        this.capacitaMassima = capacitaMassima;
    }

    @Override
    public String toString() {
        return super.getTarga() + ":" + this.capacitaMassima;
    }
}
