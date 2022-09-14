package module5.streamingService;

import java.util.HashSet;

public class Main {

    public static void main(String[] args){
        Profilo profilo1 = new Profilo("test@yahoo.com", "123quatro5", Abbonamento.BASIC);
        Utente utente1 = new Utente("User1", "./thumbnail_1.jpg", TipoUtente.NORMALE, "1234" );
        Utente utente2 = new Utente("kiddo", "./baby_boss.jpg", TipoUtente.KID, "4321" );
        Utente utente3 = new Utente("User3", "./thumbnail_45.jpg", TipoUtente.NORMALE, "12thr33" );

        Film filmTheNun = new Film("The Nun", 2018, Genere.HORROR, "VM14", false);
        Film filmSavingPrivateRyan = new Film("Saving Private Ryan", 1998, Genere.WAR, "VM14", false);
        Film filmTheConjuring = new Film("The Conjuring", 2013, Genere.HORROR, "VM14", false);
        Film filmMrBrooks = new Film("Mr Brooks", 2007, Genere.ACTION, "VM14", false);
        Film filmTwilight = new Film("Twilight", 2008, Genere.FANTASY, "T", false);

        Documentario docNature = new Documentario("Nature", 2008, Genere.DOCUMENTARY, "T", false);
        Documentario docWorldWar2 = new Documentario("World War 2", 2008, Genere.DOCUMENTARY, "T", false);
        Film filmArrival = new Film("Arrival", 2016, Genere.FANTASY, "VM14", false);
        Film filmRidSix = new Film("The Ridiculous Six", 2015, Genere.COMEDY, "VM14", false);

        SerieTV serieMrRobot = new SerieTV("Mr Robot", 2015, Genere.DRAMA, "VM14", false, 4, 11);
        SerieTV seriePeakyBlinders = new SerieTV("Peaky Blinders", 2013, Genere.DRAMA, "VM14", true, 6, 6);

        HashSet<ProdottoCatalogo> prodotti = new HashSet<>();
        prodotti.add(filmTheNun);
        prodotti.add(filmTheConjuring);
        prodotti.add(filmSavingPrivateRyan);
        prodotti.add(filmMrBrooks);
        prodotti.add(filmTwilight);
        prodotti.add(seriePeakyBlinders);
        prodotti.add(serieMrRobot);
        prodotti.add(docNature);
        prodotti.add(filmArrival);
        prodotti.add(filmRidSix);
        prodotti.add(docWorldWar2);
        Catalogo catalogo = new Catalogo(prodotti);

        profilo1.addUtente(utente1);
        profilo1.addUtente(utente2);
        profilo1.addUtente(utente3);

//        profilo1.printUtenti();

        //Test Abbonamento Standard
        profilo1.setTipoDiOferta(Abbonamento.STANDARD);
        utente1.rateFilm(prodotti, filmTheConjuring, 5);
        utente1.rateFilm(prodotti, filmArrival, 5);

        utente2.rateFilm(prodotti, filmTheConjuring, 2);
        utente2.rateFilm(prodotti, filmTheConjuring, 4);
        utente2.rateFilm(prodotti, filmSavingPrivateRyan, 5);
        utente2.rateFilm(prodotti, serieMrRobot, 2);
        utente2.rateFilm(prodotti, filmArrival, 5);

        filmTheConjuring.printValutazione();
        utente2.rateFilm(prodotti, filmTheConjuring, 5);
        filmTheConjuring.printValutazione();

        utente3.rateFilm(prodotti, filmMrBrooks, 4);
        utente3.rateFilm(prodotti, serieMrRobot, 5);
        utente3.rateFilm(prodotti, filmArrival, 5);

//        System.out.println("Utente2 valutazione: ");
//        utente2.getMyValutazione();
//
//        System.out.println("Utente1 valutazione: ");
//        utente1.getMyValutazione();
//
//        System.out.println("Catalogo: ");
//        catalogo.printCatalogo();

        utente1.addToList(filmSavingPrivateRyan);
        utente1.addToList(filmTheNun);
        utente1.addToList(filmTheConjuring);
        utente1.addToList(serieMrRobot);
        utente1.addToList(filmArrival);
//        utente1.printMyList();


        utente2.addToList(seriePeakyBlinders);
        utente2.addToList(filmTheNun);
        utente2.addToList(filmTheConjuring);
        utente2.addToList(filmArrival);
//        utente2.printMyList();


        utente3.addToList(serieMrRobot);
        utente3.addToList(seriePeakyBlinders);
        utente3.addToList(filmArrival);
        utente3.addToList(filmRidSix);
//        utente3.printMyList();

        //Test Abbonamento Premium
        profilo1.setTipoDiOferta(Abbonamento.PREMIUM);

//        utente1.printRaccomandazioneGenere(catalogo, Genere.HORROR);
//        utente1.printRaccomandazioneCategoria(catalogo, filmSavingPrivateRyan);


        utente2.printRaccomandazioniProdotti(catalogo);


        utente2.printTopRaccomandazioniProdotti(catalogo);
        utente3.rateFilm(prodotti, docNature, 4);
        utente2.printTopRaccomandazioniProdotti(catalogo);

        profilo1.setTipoDiOferta(Abbonamento.BASIC);
        utente2.printTopRaccomandazioniProdotti(catalogo);;//Error test - premium subscription needed

    }

}
