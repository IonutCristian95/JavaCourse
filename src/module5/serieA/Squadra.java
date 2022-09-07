package module5.serieA;

import java.util.ArrayList;
import java.util.List;

public class Squadra {
/**
 * id
 * nome
 * rosa di giocatori
 * punteggio
 * gol fatti
 * gol subiti
 */
    private String id;
    private String nome;
    private List<Giocatore> rosaGiocatori;
    private int punteggio;
    private int golFatti;
    private int golSubiti;

    public Squadra(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.rosaGiocatori = new ArrayList<>(25);
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

    public void setGolFatti(int golFatti) {
        this.golFatti += golFatti;
    }

    public int getGolSubiti() {
        return golSubiti;
    }

    public void setGolSubiti(int golSubiti) {
        this.golSubiti += golSubiti;
    }
}
