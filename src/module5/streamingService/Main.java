package module5.streamingService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Profilo profilo1 = new Profilo("test@yahoo.com", "123quatro5", Abbonamento.BASIC);
        Utente utente1 = new Utente("User1", "./thumbnail_1.jpg", TipoUtente.NORMALE, "1234" );
        Utente utente2 = new Utente("kiddo", "./baby_boss.jpg", TipoUtente.KID, "4321" );

        Film filmTheNun = new Film("The Nun", 2018, Genere.HORROR, "VM14", false);
        Film filmSavingPrivateRyan = new Film("Saving Private Ryan", 1998, Genere.WAR, "VM14", false);
        Film filmTheConjuring = new Film("The Conjuring", 2013, Genere.HORROR, "VM14", false);
        Film filmMrBrooks = new Film("Mr Brooks", 2007, Genere.ACTION, "VM14", false);
        Film filmTwilight = new Film("Twilight", 2008, Genere.FANTASY, "T", false);

        SerieTV serieMrRobot = new SerieTV("Mr Robot", 2015, Genere.DRAMA, "VM14", false, 4, 11);
        SerieTV seriePeakyBlinders = new SerieTV("Peaky Blinders", 2013, Genere.DRAMA, "VM14", true, 6, 6);

        List<ProdottoCatalogo> prodotti = new ArrayList<>();
        prodotti.add(filmTheNun);
        prodotti.add(filmTheConjuring);
        prodotti.add(filmSavingPrivateRyan);
        prodotti.add(filmMrBrooks);
        prodotti.add(filmTwilight);
        prodotti.add(seriePeakyBlinders);
        prodotti.add(serieMrRobot);
        Catalogo catalogo = new Catalogo(prodotti);

        profilo1.addUtente(utente1);
        profilo1.addUtente(utente2);

//        profilo1.printUtenti();

        //Test Abbonamento Standard
        profilo1.setTipoDiOferta(Abbonamento.STANDARD);
        utente1.rateFilm(prodotti, filmTheConjuring, 5);

        utente2.rateFilm(prodotti, filmTheConjuring, 2);
        utente2.rateFilm(prodotti, filmSavingPrivateRyan, 5);

        filmTheConjuring.printValutazione();
        utente2.rateFilm(prodotti, filmTheConjuring, 5);
        filmTheConjuring.printValutazione();

        System.out.println("Utente2 valutazione: ");
        utente2.getMyValutazione();

        System.out.println("Utente1 valutazione: ");
        utente1.getMyValutazione();

        System.out.println("Catalogo: ");
        catalogo.printCatalogo();

        utente1.addToList(filmSavingPrivateRyan);
        utente1.printMyList();


        utente2.addToList(seriePeakyBlinders);
        utente2.addToList(filmTheNun);
        utente2.printMyList();

        //Test Abbonamento Premium
        profilo1.setTipoDiOferta(Abbonamento.PREMIUM);

        utente1.printRaccomandazioneGenere(catalogo, Genere.HORROR);
        utente1.printRaccomandazioneCategoria(catalogo, filmSavingPrivateRyan);

        System.out.println("Raccomandazioni prodotti test:");
        utente2.printRaccomandazioniProdotti(catalogo);

    }

}
