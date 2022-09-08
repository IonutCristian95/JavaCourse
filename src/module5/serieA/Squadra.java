package module5.serieA;

import java.util.ArrayList;
import java.util.List;

public class Squadra {
    private int id;
    private String nome;
    private List<Giocatore> rosaGiocatori;
    private int punteggio;
    private int golFatti;
    private int golSubiti;

    public Squadra(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.rosaGiocatori = new ArrayList<>();
        this.punteggio = 0;
        this.golFatti = 0;
        this.golSubiti = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void increasePunteggio(int punteggio) {
        this.punteggio += punteggio;
    }

    public int getGolFatti() {
        return golFatti;
    }

    public void increaseGolFatti(int golFatti) {
        this.golFatti += golFatti;
    }

    public int getGolSubiti() {
        return golSubiti;
    }

    public void increaseGolSubiti(int golSubiti) {
        this.golSubiti += golSubiti;
    }

    public void printRosaDiGiocatori(){
        System.out.println("Squadra " + this.getNome());
        for(Giocatore giocatore : rosaGiocatori){
            System.out.println(giocatore);
        }
    }

    public void addGiocatore(Giocatore giocatore){
        if(!giocatore.equals(null)){
            rosaGiocatori.add(giocatore);
        }
    }
}
