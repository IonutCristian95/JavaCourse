package Day4;

public class Lampadina {
    private Stato stato;
    private static Corrente corrente;
    private int maxClicksSuppoted;
    private int currentClicks = 0;

    public Lampadina(int maxClicksSuppoted){
        this.maxClicksSuppoted = maxClicksSuppoted;
        this.stato = Stato.SPENTA;
    }

    public static void staccareRiattacareImpianto(){
        corrente = (corrente== Corrente.STACCARE) ? Corrente.ATTACCARE : Corrente.STACCARE;
    }

    public Stato stato(){
        if(corrente== Corrente.STACCARE && stato==Stato.ACCESA){
            return Stato.SPENTA;
        }
        return this.stato;
    }

    public void click(){
        if(currentClicks >= maxClicksSuppoted){
            this.stato = Stato.ROTTA;
            return;
        }
        currentClicks++;
        this.stato = (this.stato == Stato.ACCESA) ? Stato.SPENTA : Stato.ACCESA;
    }
}
