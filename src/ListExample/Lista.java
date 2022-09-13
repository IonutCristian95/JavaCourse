package ListExample;

public interface Lista<T> {
    /*
    Progettare un'interfaccia Lista che permette di fare le seguenti operazioni
* get(int i) che restituisce l'elemento alla posizione i della sequenza
* contains(Object o) che restituisce true se l'elemento o è presente nella sequenza
* size() che restituisce quanti elementi sono presenti all'interno della sequenza
* add(Object o) che aggiunge un elemento alla sequenza
* remove(int i) che rimuove l'elemento alla posizione i della sequenza, torna true se l'elemento è stato rimosso, false se non l'ha trovato
* clear() rimuove tutti gli elementi dalla sequenza

Aggiungere l'interfaccia Lista alle classi ListaDiInteri e MiaStringa, ed implementarne i metodi

Usare il codice di test per verificare le funzioni
     */
    T get(int i);
    boolean contains(T object);
    int size();
    void add(T object);
    boolean remove(int i);
    void clear();
}
