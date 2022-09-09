package module5.serieA;

public class Main {
    public static void main(String[] args) {
        Classifica classifica = new Classifica();
        Giocatore giocatoreJuve = new Giocatore(1, "Federico", "Chiesa");
        Giocatore giocatoreJuve1 = new Giocatore(2, "Angel", "Di Maria");

        Squadra atalanta = new Squadra(1,"Atalanta");
        Squadra napoli = new Squadra(2,"Napoli");
        Squadra milan = new Squadra(3,"Milan");
        Squadra udinese = new Squadra(4,"Udinese");
        Squadra roma = new Squadra(5,"Roma");
        Squadra torino = new Squadra(6,"Torino");
        Squadra juventus = new Squadra(7,"Juventus");
        Squadra inter = new Squadra(8,"Inter");
        Squadra lazio = new Squadra(9,"Lazio");
        Squadra salernitana = new Squadra(10,"Salernitana");


        classifica.addSquadra(atalanta);
        classifica.addSquadra(napoli);
        classifica.addSquadra(milan);
        classifica.addSquadra(udinese);
        classifica.addSquadra(roma);
        classifica.addSquadra(torino);
        classifica.addSquadra(juventus);
        classifica.addSquadra(inter);
        classifica.addSquadra(lazio);
        classifica.addSquadra(salernitana);

        classifica.esitoPartita(napoli, 6, lazio, 1);
        classifica.esitoPartita(juventus, 3, roma, 2);
        classifica.esitoPartita(salernitana, 3, inter, 3);
        classifica.esitoPartita(udinese, 0, torino, 4);
        classifica.esitoPartita(milan, 0, atalanta, 5);

        classifica.esitoPartita(juventus, 4, napoli, 0);

        classifica.getClassifica();
        classifica.getMigliorAttacco();
        classifica.getPeggiorDifesa();

        juventus.addGiocatore(giocatoreJuve);
        juventus.addGiocatore(giocatoreJuve1);

        juventus.printRosaDiGiocatori();
    }
}
