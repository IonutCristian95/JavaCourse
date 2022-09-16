package module7.libraryV2;

public class AuthorNotFoundException extends Exception{
    public AuthorNotFoundException(Autore author) {
        super("Author " + author + " was not found.");
    }
}
