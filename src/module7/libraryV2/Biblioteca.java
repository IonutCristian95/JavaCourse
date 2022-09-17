package module7.libraryV2;

import java.util.HashMap;
import java.util.TreeMap;

public class Biblioteca {
    public HashMap<Autore, TreeMap<String, Libro>> biblioteca = new HashMap<>();

    public void insertBook(Autore author, Libro book){
        if (author==null || book==null)
            return;

        HashMap<Autore, TreeMap<String, Libro>> bibliotecaTemp = biblioteca;
        TreeMap<String, Libro> tempBook = new TreeMap<>();
        tempBook.put(book.getTitolo(), book);
        if (bibliotecaTemp.containsKey(author)){
            bibliotecaTemp.get(author).put(book.getTitolo(), book);
        }else{
            bibliotecaTemp.put(author, tempBook);
        }
    }

    public void deleteBook(Autore autore, Libro book){
        if (autore == null || book == null){
            return;
        }
        System.out.println("Book " + biblioteca.get(autore).remove(book.getTitolo()).getTitolo() + " is deleted.");
    }

    public void searchBookByCode(String code) throws BookNotFoundException{
        for (Autore autore : biblioteca.keySet()) {
            for (Libro book : biblioteca.get(autore).values()) {
                if (code.equals(book.getCodice())){
                    System.out.println("Found: " + book);
                    return;
                }
            }
        }
        throw new BookNotFoundException();
    }

    public void searchBookByTitle(String title) throws BookNotFoundException{
        boolean found = false;
        for (Autore autore : biblioteca.keySet()) {
            for (Libro book : biblioteca.get(autore).values()) {
                if (book.getTitolo().contains(title)){
                    found = true;
                    System.out.println("Found: " + book);
                }
            }
        }

        if(!found) throw new BookNotFoundException();
    }

    public void searchBookByAuthor(Autore author) throws AuthorNotFoundException{
        if(biblioteca.get(author)==null){
            throw new AuthorNotFoundException(author);
        }
        biblioteca.get(author).values().forEach(System.out::println);
    }

    public void printBooksByAuthor(Autore author) throws AuthorNotFoundException{
        if(biblioteca.getOrDefault(author, null)==null){
            throw new AuthorNotFoundException(author);
        }
        System.out.println(author);
        for (Libro value : biblioteca.get(author).values()) {
            System.out.print(value + "\n");
        }
    }

    public void printLibrary(){
        System.out.println("Library: ");
        for (Autore autore : biblioteca.keySet()) {
            System.out.println(autore + ": " + biblioteca.get(autore));
        }
    }
}
