package module7;


public class Cliente {
    private String nome;
    private String cognome;
    private int eta;
    private int id;
    private Cliente next;

    public Cliente(String nome, String cognome, int eta, int id) {
        this.nome = nome;
        this.cognome = cognome;
        this.setEta(eta);
        this.id = id;
        this.next = null;
    }

    public Cliente getNext() {
        return next;
    }

    public void setNext(Cliente next) {
        this.next = next;
    }

    public int getEta() {
        return eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getId() {
        return id;
    }

    public void setEta(int eta) {
        if(eta > 0){
            this.eta = eta;
        }else{
            this.eta = 0;
        }
    }

    @Override
    public String toString() {
        return this.getNome() + " " + this.getCognome() + " " + this.getEta() + " " + this.getId();
    }
}
