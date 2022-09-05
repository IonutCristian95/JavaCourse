package Day4;

public class AutoMobile extends Veicolo{
    private int numeroPorte;

    public AutoMobile(String targa, int numeroPosti, int numeroPorte) {
        super(targa, numeroPosti);
        this.numeroPorte = numeroPorte;
    }

    @Override
    public String toString() {
        return super.getTarga()+":"+this.numeroPorte;
    }
}
