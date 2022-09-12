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

    public Hashtable<ProdottoCatalogo, Integer> getMyValutazione(){
        if(notAbbonamentoStandard()){
            return null;
        }
        for(ProdottoCatalogo prod : myValutazione.keySet()){
            System.out.println(prod);
        }
        return this.myValutazione;
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
