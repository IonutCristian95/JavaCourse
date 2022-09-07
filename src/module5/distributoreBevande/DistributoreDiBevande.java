package module5.distributoreBevande;

import java.util.ArrayList;
import java.util.List;

public class DistributoreDiBevande {
    private List<Prodotto> prodotti;
    private double saldo;

    public DistributoreDiBevande(int n){
        prodotti = new ArrayList<>(n);
        saldo = 0d;
    }

    public void caricaProdotto(Prodotto prodotto) {
        if (!prodotto.equals(null)){
            prodotti.add(prodotto);
        }
        System.out.println("Caricatto : " + prodotto);
    }

    public double saldoAttuale() {
        System.out.println(this.saldo);
        return this.saldo;
    }

    public double getResto() {
        System.out.println(this.saldo);
        double temp = this.saldo;
        this.saldo = 0;
        return temp;
    }

    public void inserisciImporto(double v) {
        if (v > 0){
            this.saldo += v;
        }
    }

    public Prodotto scegliProdotto(String prodotto) {
        Prodotto temp = null;
        for(Prodotto prod : prodotti){
            if((prod.getNomeProdotto()).equals(prodotto)){
                if( prod.getPrezzo() > this.saldo){
                    return null;
                }
                temp = prod;
                this.saldo -= prod.getPrezzo();
                prodotti.remove(prod);
                break;
            }
        }

        return temp;
    }

}
