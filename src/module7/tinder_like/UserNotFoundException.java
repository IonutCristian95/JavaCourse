package module7.tinder_like;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Utente utente) {
        super(utente + " not found.");
    }
}
