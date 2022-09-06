package Day4;

public enum Corrente {
    STACCARE,
    ATTACCARE;
    private Corrente currentStatus;

    public void staccareRiattacareImpianto(){
        currentStatus = (currentStatus==Corrente.STACCARE) ? Corrente.ATTACCARE : Corrente.STACCARE;
    }

    public Corrente getCurrentStatus() {
        return currentStatus;
    }
}
