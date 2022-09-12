package module5.streamingService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

public class Catalogo {
    private List<ProdottoCatalogo> catalogo;

    public Catalogo(List<ProdottoCatalogo> catalogo) {
        this.catalogo = catalogo;
    }

    public void printCatalogo(){
        for(ProdottoCatalogo prod : catalogo){
            System.out.println(prod);
        }
    }

    public List<ProdottoCatalogo> getCatalogo() {
        return catalogo;
    }

    public void printRaccomandazioneGenere(Utente utente, Genere genere){
        if(utente.notAbbonamentoPremium()){
            return ;
        }

        System.out.println("Raccomandazione per genere " + genere);
        for(ProdottoCatalogo prod : this.getCatalogo()){
            if(prod.getGenere().equals(genere)){
                System.out.println(prod);
            }
        }
    }

    public void printRaccomandazioneCategoria(Utente utente, ProdottoCatalogo film){
        if(utente.notAbbonamentoPremium()){
            return ;
        }

        System.out.println("Raccomandazione per categoria " + film.getClass().getSimpleName());
        for(ProdottoCatalogo prod : this.getCatalogo()){
            if(prod.getClass().equals(film.getClass())){
                System.out.println(prod);
            }
        }
    }

    /*
    Creare un metodo che, dato un Utente, ritorni una lista di altri prodotti in catalogo che potrebbero interessargli
    basandosi sugli elementi presenti nella sua lista e sulle sue valutazioni dei prodotti;
     */
    public void printRaccomandazioniProdotti(Utente utente){
        if(utente.notAbbonamentoPremium()){
            return ;
        }
        System.out.println("***************Raccomandazioni prodotti***************");
        Hashtable<String, ProdottoCatalogo> temp = new Hashtable<>();
        List<ProdottoCatalogo> toRecommend = new ArrayList<>();
        for(ProdottoCatalogo prod : utente.getMyList()){
            temp.putIfAbsent(prod.getGenere().toString(), prod);
            temp.putIfAbsent(prod.getClass().getSimpleName(), prod);
        }

        for(ProdottoCatalogo prod : utente.getMyValutazione().keySet()){
            temp.putIfAbsent(prod.getGenere().toString(), prod);
            temp.putIfAbsent(prod.getClass().getSimpleName(), prod);
        }

        for(ProdottoCatalogo prod : this.getCatalogo()){
            if(temp.get(prod.getGenere().toString())!=null && (!toRecommend.contains(prod))){
                System.out.println(prod);
                toRecommend.add(prod);
                continue;
            }
            if(temp.get(prod.getClass().getSimpleName())!=null && (!toRecommend.contains(prod))){
                System.out.println(prod);
                toRecommend.add(prod);
            }
        }
    }

    /*
    Creare un metodo che, data una lista di Utenti, ritorna una lista dei 10 titoli più popolari basandosi
    sugli elementi presenti nelle loro liste e sulle valutazioni dei prodotti.
     */
    public void printTopRaccomandazioniProdotti(List<Utente> utenti){
        if(!utenti.get(0).notAbbonamentoPremium()){
            return ;
        }

        System.out.println("***************Top raccomandazioni***************");
        ArrayList<ProdottoCatalogo> list = new ArrayList<>(this.getCatalogo());


        list.sort(new Comparator<ProdottoCatalogo>() {
            @Override
            public int compare(ProdottoCatalogo o1, ProdottoCatalogo o2) {
                return o2.getValutazione()-o1.getValutazione();
            }
        });

        list.sort(new Comparator<ProdottoCatalogo>() {
            @Override
            public int compare(ProdottoCatalogo o1, ProdottoCatalogo o2) {
                return o2.getPreferredCounter()-o1.getPreferredCounter();
            }
        });

        int counter = 0;
        for(ProdottoCatalogo prod : list){
            if (counter > 9) {
                break;
            }
            System.out.println(prod);
            counter++;
        }

    }
}
