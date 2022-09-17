package module7.tinder_like;

import java.util.HashSet;

public class Utente {
    private HashSet<Interesse> userInterests;
    private String firstName;
    private String lastName;

    public Utente(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        userInterests = new HashSet<>();
    }

    public void addInterest(Interesse interesse){
        userInterests.add(interesse);
    }

    public HashSet<Interesse> getUserInterests() {
        return userInterests;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
