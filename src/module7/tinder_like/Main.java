package module7.tinder_like;

public class Main {
    public static void main(String[] args) {
        Interesse interesse = new Interesse("Teaching");
        Interesse interesse1 = new Interesse("Travelling");
        Interesse interesse2 = new Interesse("Chatting overnight");
        Interesse interesse3 = new Interesse("Hiking");
        Interesse interesse4 = new Interesse("Surfing");
        Interesse interesse5 = new Interesse("Reading");

        Utente martinRusso = new Utente("Martin", "Russo");
        Utente mayaJenkins = new Utente("Maya", "Jenkins");
        Utente johnSmith = new Utente("John", "Smith");
        Utente laylaBaker = new Utente("Layla", "Baker");

        Tinder tinder = new Tinder();

        tinder.insertUser(martinRusso, interesse);
        tinder.insertUser(martinRusso, interesse3);
        tinder.insertUser(martinRusso, interesse4);
        tinder.insertUser(martinRusso, interesse5);

        tinder.insertUser(mayaJenkins, interesse2);
        tinder.insertUser(mayaJenkins, interesse1);
        tinder.insertUser(mayaJenkins, interesse5);

        tinder.insertUser(johnSmith, interesse);
        tinder.insertUser(johnSmith, interesse2);
        tinder.insertUser(johnSmith, interesse1);
        tinder.insertUser(johnSmith, interesse5);

        tinder.insertUser(laylaBaker, interesse4);
        tinder.insertUser(laylaBaker, interesse3);
        tinder.insertUser(laylaBaker, interesse2);
        try{
            tinder.commonInterests(mayaJenkins);
            tinder.commonInterests(martinRusso);

            tinder.getBestMatches(mayaJenkins);
        } catch (UserNotFoundException unfe){
            System.out.println(unfe.getMessage());
        }


    }
}
