package module5.streamingService;

import module5.distributoreBevande.Prodotto;

import java.util.*;

public class Utente {
    private String nome;
    private String urlAvatar;
    private TipoUtente tipoUtente;
    private String pin;
    private Profilo profile;
    private List<ProdottoCatalogo> myList;

    private Hashtable<ProdottoCatalogo, Integer> myValutazione;


    public Utente(String nome, String urlAvatar, TipoUtente tipoUtente, String pin) {
        this.nome = nome;
        this.urlAvatar = urlAvatar;
        this.tipoUtente = tipoUtente;
        this.pin = pin;
        myList = new ArrayList<>();
        myValutazione = new Hashtable<>();
    }

    public String getNome() {
        return nome;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public TipoUtente getTipoUtente() {
        return tipoUtente;
    }

    private String getPin() {
        return pin;
    }

    public List<ProdottoCatalogo> getMyList() {
        return myList;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public void setTipoUtente(TipoUtente tipoUtente) {
        this.tipoUtente = tipoUtente;
    }

    public void setProfile(Profilo prof) {
        this.profile = prof;
    }

    public void addToList(ProdottoCatalogo prod){
        if(notAbbonamentoStandard()){
            return;
        }
        if(myList.contains(prod)){
            return ;
        }
        prod.increasePreferredCounter();
        myList.add(prod);
    }

    public void printMyList(){
        if(notAbbonamentoStandard()){
            return;
        }

        for(ProdottoCatalogo prod : myList){
            System.out.println(prod);
        }
    }

    public void rateFilm(List<ProdottoCatalogo> catalogo, ProdottoCatalogo prodotto, int valutazione){
        if(notAbbonamentoStandard()){
            return;
        }
        if(valutazione < 1 || valutazione > 5){
            return ;
        }


        if(!myValutazione.containsKey(prodotto) && valutazione >= 3){
            prodotto.increasePreferredCounter();
        }else if(!myValutazione.containsKey(prodotto) && valutazione < 3){
            prodotto.decreasePreferredCounter();
        }else if(myValutazione.containsKey(prodotto) && (valutazione < 3)){
            //Check if the user already voted <3 on that product
            if(myValutazione.get(prodotto)>=3) {
                prodotto.decreasePreferredCounter();
            }
        }else if(myValutazione.containsKey(prodotto) && valutazione >= 3){
            //Check if the previous vote is <3 on that product
            //Prevents situations where the increasePreferredCounter gets called multiple
            // times for successive values of 3, 4, 5
            if(myValutazione.get(prodotto) < 3){
                prodotto.increasePreferredCounter();
            }
        }

        for(ProdottoCatalogo prod : catalogo){
            if(prod.getTitolo().equals(prodotto.getTitolo())){
                myValutazione.put(prod, valutazione);
                prod.setValutazione(this, valutazione);
                break;
            }
        }
    }

    public void getMyValutazione(){
        if(notAbbonamentoStandard()){
            return;
        }
        for(ProdottoCatalogo prod : myValutazione.keySet()){
            System.out.println(prod);
        }
    }

    public void printRaccomandazioneGenere(Catalogo catalogo, Genere genere){
        if(notAbbonamentoPremium()){
            return ;
        }

        System.out.println("Raccomandazione per genere " + genere);
        for(ProdottoCatalogo prod : catalogo.getCatalogo()){
            if(prod.getGenere().equals(genere)){
                System.out.println(prod);
            }
        }
    }

    public void printRaccomandazioneCategoria(Catalogo catalogo, ProdottoCatalogo film){
        if(notAbbonamentoPremium()){
            return ;
        }

        System.out.println("Raccomandazione per categoria " + film.getClass().getSimpleName());
        for(ProdottoCatalogo prod : catalogo.getCatalogo()){
            if(prod.getClass().equals(film.getClass())){
                System.out.println(prod);
            }
        }
    }

    /*
    Creare un metodo che, dato un Utente, ritorni una lista di altri prodotti in catalogo che potrebbero interessargli
    basandosi sugli elementi presenti nella sua lista e sulle sue valutazioni dei prodotti;
     */
    public void printRaccomandazioniProdotti(Catalogo catalogo){
        if(notAbbonamentoPremium()){
            return ;
        }
        Hashtable<String, ProdottoCatalogo> temp = new Hashtable<>();
        List<ProdottoCatalogo> toRecommend = new ArrayList<>();
        for(ProdottoCatalogo prod : this.myList){
            temp.putIfAbsent(prod.getGenere().toString(), prod);
            temp.putIfAbsent(prod.getClass().getSimpleName(), prod);
        }

        for(ProdottoCatalogo prod : this.myValutazione.keySet()){
            temp.putIfAbsent(prod.getGenere().toString(), prod);
            temp.putIfAbsent(prod.getClass().getSimpleName(), prod);
        }

        for(ProdottoCatalogo prod : catalogo.getCatalogo()){
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
    public void printTopRaccomandazioniProdotti(List<Utente> utenti, Catalogo catalogo){
        for (Utente utente : utenti){
            if(utente.notAbbonamentoPremium()){
                return ;
            }
        }

        ArrayList<ProdottoCatalogo> list = new ArrayList<>(catalogo.getCatalogo());
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

    @Override
    public String toString() {
        return "Nome utente: " + this.getNome() + " Tipo utente: " + getTipoUtente();
    }

    private boolean notAbbonamentoStandard(){
        if(profile.getTipoDiOferta().equals(Abbonamento.BASIC)){
            System.out.println("Error: current subscription is Basic");
            return true;
        }
        return false;
    }

    public boolean notAbbonamentoPremium(){
        if(!profile.getTipoDiOferta().equals(Abbonamento.PREMIUM)){
            System.out.println("Error: current subscription is " + profile.getTipoDiOferta());
            return true;
        }
        return false;
    }

}
