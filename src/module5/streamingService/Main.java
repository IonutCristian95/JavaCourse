package module5.streamingService;

public class Main {

    public static void main(String[] args){
        Profilo profilo1 = new Profilo("test@yahoo.com", "123quatro5", Abbonamento.BASIC);
        Utente utente1 = new Utente("User1", "./thumbnail_1.jpg", TipoUtente.NORMALE, "1234" );
        Utente utente2 = new Utente("kiddo", "./baby_boss.jpg", TipoUtente.KID, "4321" );

        Film filmTheNun = new Film("The Nun", 2018, Genere.HORROR, "VM14", false);
        Film filmSavingPrivateRyan = new Film("Saving Private Ryan", 1998, Genere.WAR, "VM14", false);
        Film filmTheConjuring = new Film("The Conjuring", 2013, Genere.HORROR, "VM14", false);

        SerieTV seriePeakyBlinders = new SerieTV("Peaky Blinders", 2013, Genere.DRAMA, "VM14", true, 6, 6);

        profilo1.addUtente(utente1);
        profilo1.addUtente(utente2);




    }

}
