package module7.libraryV2;

public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super("The book was not found." );
    }
}
