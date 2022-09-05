package Day4;

import java.util.Arrays;

/**
 * Esercizio Biblioteca 🛴
 *
 * Scrivere un programma che permetta di gestire una Biblioteca semplificata, in grado di gestire un array di indici (interi)
 * dei libri che contiene. La Biblioteca viene costruita a partire da un array di indici di libri.
 * In particolare, implementare i seguenti metodi:
 * - esisteLibro: prende un indice e restituisce true se esiste il libro con questo indice, false altrimenti
 * - getIndiciLibriOrdinati: ritorna la lista degli indici di libri presenti nella library, in ordine ascendente
 * ```
 *
 * Suggerimento: riutilizzate il codice dei precedenti esercizi
 */

public class Biblioteca {
    private int[] values;

    public Biblioteca(int[] values) {
        this.values = values;
    }

    public boolean esisteLibro(int libro){
        for(int value : this.values){
            if(value == libro){
                return true;
            }
        }
        return false;
    }

    public int[] getIndiciLibriOrdinati(){
        Arrays.sort(this.values);
        return this.values;
    }
}
