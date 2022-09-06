package Day4;

public class Lampadina {
    private Stato stato;
    private static Corrente impianto;
    private int maxClicksSuppoted;
    private int currentClicks = 0;

    public Lampadina(int maxClicksSuppoted, Corrente impianto){
        this.maxClicksSuppoted = maxClicksSuppoted;
        this.stato = Stato.SPENTA;
        this.impianto = impianto;
    }

    public Stato stato(){
        if(impianto.getCurrentStatus()== Corrente.STACCARE && stato==Stato.ACCESA){
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
