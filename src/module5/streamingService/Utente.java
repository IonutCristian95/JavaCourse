package module5.streamingService;

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

    public void rateFilm(List<ProdottoCatalogo> catalogo, ProdottoCatalogo film, int valutazione){
        if(notAbbonamentoStandard()){
            return;
        }
        if(valutazione < 1 || valutazione > 5){
            return ;
        }

        for(ProdottoCatalogo prod : catalogo){
            if(prod.getTitolo().equals(film.getTitolo())){
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
    public List<ProdottoCatalogo> printRaccomandazioniProdotti(Catalogo catalogo){
        if(notAbbonamentoPremium()){
            return null;
        }
        Hashtable<String, ProdottoCatalogo> temp = new Hashtable<>();
        List<ProdottoCatalogo> alreadyRecommended = new ArrayList<>();
        for(ProdottoCatalogo prod : this.myList){
            temp.putIfAbsent(prod.getGenere().toString(), prod);
            temp.putIfAbsent(prod.getClass().getSimpleName(), prod);
        }

        for(ProdottoCatalogo prod : catalogo.getCatalogo()){
            if(temp.get(prod.getGenere().toString())!=null && (!alreadyRecommended.contains(prod))){
                System.out.println(prod);
                alreadyRecommended.add(prod);
                continue;
            }
            if(temp.get(prod.getClass().getSimpleName())!=null && (!alreadyRecommended.contains(prod))){
                System.out.println(prod);
                alreadyRecommended.add(prod);
            }
        }
        return alreadyRecommended;
    }

    /*
    Creare un metodo che, data una lista di Utenti, ritorna una lista dei 10 titoli più popolari basandosi
    sugli elementi presenti nelle loro liste e sulle valutazioni dei prodotti.
     */
    public void printTopRaccomandazioniProdotti(List<Utente> utenti, Catalogo catalogo){
        if(utenti.get(0).notAbbonamentoPremium()){
            return ;
        }
        HashMap<ProdottoCatalogo, Integer> prodottiUtenti = new HashMap<>();
        LinkedHashMap<ProdottoCatalogo, Integer> finalListRaccomandazioni = new LinkedHashMap<>();
        //Get all movies,series,documentaries from the users and each time there is one, increase the counter
        int appreciationCounter = 0;
        for(Utente utente : utenti){
            for(ProdottoCatalogo prodottoCatalogo : utente.getMyList()){
                if(prodottiUtenti.get(prodottoCatalogo)!=null){
                    appreciationCounter = prodottiUtenti.get(prodottoCatalogo);
                    appreciationCounter++;
                    prodottiUtenti.put(prodottoCatalogo, appreciationCounter);
                }else{
                    prodottiUtenti.put(prodottoCatalogo, 0);
                }
            }
        }
        //Save a list with alreadyRecommended products
        List<ProdottoCatalogo> alreadyRecommended = new ArrayList<>(prodottiUtenti.keySet());

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<ProdottoCatalogo, Integer> entry : prodottiUtenti.entrySet()) {
            list.add(entry.getValue());
        }
        list.sort(new Comparator<Integer>() {
            public int compare(Integer value1, Integer value2) {
                return value1 - value2;
            }
        });

        for (Integer str : list) {
            for (Map.Entry<ProdottoCatalogo, Integer> entry : prodottiUtenti.entrySet()) {
                finalListRaccomandazioni.put(entry.getKey(), str);
            }
        }

        for(ProdottoCatalogo prod : finalListRaccomandazioni.keySet()){
            System.out.println(prod);
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
