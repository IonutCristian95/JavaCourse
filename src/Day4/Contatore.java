package Day4;

public class Contatore {
    private int conteggio;

    public Contatore(){
        this.conteggio = 0;
    }

    public Contatore(int conteggio){
        this.conteggio = conteggio;
    }

    public void incrementConteggio(){
        this.conteggio++;
    }

    public int getConteggio(){
        return this.conteggio;
    }

    public void resetConteggio(){
        this.conteggio = 0;
    }

    public void resetConteggio(int valore){
        this.conteggio = valore;
    }
}
