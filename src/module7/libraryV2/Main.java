package module7.libraryV2;

public class Main {
    public static void main(String[] args) {
        Autore authorAS = new Autore("Andrej", "Sapkowski");
        Autore authorDG = new Autore("Dmitri", "Glukhovsky");

        Libro metro2033 = new Libro("0A", "Metro 2033", "is a 2002 post-apocalyptic fiction novel by Russian author Dmitry Glukhovsky", authorDG);
        Libro metro2034 = new Libro("0B", "Metro 2034", "is a 2009 post-apocalyptic science fiction novel in the Metro series, written by Russian author Dmitry Glukhovsky as a sequel to his earlier Metro 2033.", authorDG);
        Libro metro2035 = new Libro("0C", "Metro 2035", "is a 2015 post-apocalyptic science fiction novel by Russian author Dmitry Glukhovsky. Glukhovsky's third book in the core Metro series, it serves as a sequel to Metro 2033 and Metro 2034.", authorDG);

        

        Biblioteca biblioteca = new Biblioteca();
    }
}
