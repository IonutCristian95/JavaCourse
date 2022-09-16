package module7.libraryV2;

import java.util.HashMap;
import java.util.TreeMap;

public class Biblioteca {
    public HashMap<Autore, TreeMap<String, Libro>> biblioteca = new HashMap<>();

    /**
     * inserimento di un Libro
     * cancellazione di un Libro
     * ricerca di un Libro a partire da codice, titolo o Autore
     */
    public void insertBook(Autore author, Libro book){
        if (author==null || book==null)
            return;

        HashMap<Autore, TreeMap<String, Libro>> bibliotecaTemp = biblioteca;
        if (bibliotecaTemp.containsKey(author)){
            bibliotecaTemp.get(author).put(book.getTitolo(), book);
        }
    }

    public void deleteBook(Autore autore, Libro book){
        if (autore == null || book == null){
            return;
        }
        System.out.println("Book " + biblioteca.get(autore).remove(book.getTitolo()).getTitolo() + " is deleted.");
    }

    public void searchBookByCode(String code){
        for (Autore autore : biblioteca.keySet()) {
            for (Libro book : biblioteca.get(autore).values()) {
                if (code.equals(book.getCodice())){
                    System.out.println(book);
                    return;
                }
            }
        }
    }

    public void searchBookByTitle(String title){
        for (Autore autore : biblioteca.keySet()) {
            for (Libro book : biblioteca.get(autore).values()) {
                if (title.equals(book.getTitolo())){
                    System.out.println(book);
                    return;
                }
            }
        }
    }

    //To Do
    public void searchBookByAuthor(Autore author){
        for (Autore autore : biblioteca.keySet()) {
            System.out.println(biblioteca.get(autore));
        }
    }

    public void printBooksByAuthor(Autore author) throws AuthorNotFoundException{
        if(biblioteca.getOrDefault(author, null)==null){
            throw new AuthorNotFoundException(author);
        }
        for (Libro value : biblioteca.get(author).values()) {
            System.out.print(value + "\n");
        }
    }

    public void printLibrary(){
        System.out.println(biblioteca);
    }
}
