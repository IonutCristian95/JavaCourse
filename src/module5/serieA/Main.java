package module5.serieA;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Classifica classifica = new Classifica(5);

        Squadra squadra = new Squadra(1,"Atalanta");
        Squadra squadra1 = new Squadra(2,"Napoli");
        Squadra squadra2 = new Squadra(3,"Milan");
        Squadra squadra3 = new Squadra(4,"Udinese");
        Squadra squadra4 = new Squadra(5,"Roma");
        Squadra squadra5 = new Squadra(6,"Torino");
        Squadra squadra6 = new Squadra(7,"Juventus");
        Squadra squadra7 = new Squadra(8,"Inter");
        Squadra squadra8 = new Squadra(9,"Lazio");
        Squadra squadra9 = new Squadra(10,"Salernitana");


        classifica.addSquadra(squadra);
        classifica.addSquadra(squadra1);
        classifica.addSquadra(squadra2);
        classifica.addSquadra(squadra3);
        classifica.addSquadra(squadra4);
        classifica.addSquadra(squadra5);
        classifica.addSquadra(squadra6);
        classifica.addSquadra(squadra7);
        classifica.addSquadra(squadra8);
        classifica.addSquadra(squadra9);

        classifica.esitoPartita(squadra1, 6, squadra8, 1);
        classifica.esitoPartita(squadra6, 3, squadra4, 2);
        classifica.esitoPartita(squadra9, 3, squadra7, 3);
        classifica.esitoPartita(squadra3, 0, squadra5, 4);
        classifica.esitoPartita(squadra2, 0, squadra, 5);


        classifica.esitoPartita(squadra6, 6, squadra1, 2);

        classifica.getClassifica();
        classifica.getMigliorAttacco();
        classifica.getPeggiorDifesa();
    }
}
