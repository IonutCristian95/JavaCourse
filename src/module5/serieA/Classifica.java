package module5.serieA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Classifica {
    private List<Squadra> squadre;

    public Classifica(int numeroSquadre) {
        this.squadre = new ArrayList<>(numeroSquadre);
    }

    public void addSquadra(Squadra squadra){
        squadre.add(squadra);
    }

    public void esitoPartita(Squadra squadraCasa, int golCasa, Squadra squadraOspite, int golOspite){
        if(golCasa==golOspite){
            squadraCasa.increasePunteggio(1);
            squadraOspite.increasePunteggio(1);
        }else if(golCasa>golOspite){
            squadraCasa.increasePunteggio(3);
        }else{
            squadraOspite.increasePunteggio(3);
        }

        squadraCasa.setGolFatti(golCasa);
        squadraCasa.setGolSubiti(golOspite);

        squadraOspite.setGolFatti(golOspite);
        squadraOspite.setGolSubiti(golCasa);
    }

    public void getClassifica(){
        this.squadre.sort(new Comparator<Squadra>(){
            @Override
            public int compare(Squadra s1, Squadra s2){
                return s1.getPunteggio()-s2.getPunteggio();
            }
        });

        for (Squadra s : squadre){
            System.out.println(s.getNome() + " punteggio: " + s.getPunteggio() + " golFatti: " + s.getGolFatti() + " golSubiti: " + s.getGolSubiti());
        }
    }

    public void getMigliorAttacco(){
        Squadra temp = null;
        int golFatti = Integer.MIN_VALUE;
        for(Squadra s : squadre){
            if(s.getGolFatti() > golFatti){
                golFatti=s.getGolFatti();
                temp = s;
            }
        }
        System.out.println("MigliorAttacco: " + temp.getNome() + " " + temp.getGolFatti());
    }

    public void getPeggiorDifesa(){
        Squadra temp = null;
        int golSubiti = Integer.MIN_VALUE;
        for(Squadra s : squadre){
            if(s.getGolSubiti() > golSubiti){
                golSubiti = s.getGolSubiti();
                temp = s;
            }
        }
        System.out.println("PeggiorDifesa: " + temp.getNome() + " " + temp.getGolSubiti());
    }
}
