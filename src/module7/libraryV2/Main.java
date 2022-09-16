package module7.libraryV2;

public class Main {
    public static void main(String[] args) {
        Autore authorAS = new Autore("Andrej", "Sapkowski");
        Autore authorDG = new Autore("Dmitri", "Glukhovsky");
        Autore authorHPL = new Autore("Howard Phillips", "Lovecraft");
        Libro metro2033 = new Libro("0A", "Metro 2033", "is a 2002 post-apocalyptic fiction novel by Russian author Dmitry Glukhovsky", authorDG);
        Libro metro2034 = new Libro("0B", "Metro 2034", "is a 2009 post-apocalyptic science fiction novel in the Metro series, written by Russian author Dmitry Glukhovsky as a sequel to his earlier Metro 2033.", authorDG);
        Libro metro2035 = new Libro("0C", "Metro 2035", "is a 2015 post-apocalyptic science fiction novel by Russian author Dmitry Glukhovsky. Glukhovsky's third book in the core Metro series, it serves as a sequel to Metro 2033 and Metro 2034.", authorDG);
        Libro theWitcher1 = new Libro("1A", "The Last Wish", "The Last Wish is the first book in Andrzej Sapkowski's The Witcher series in terms of story chronology, although the original Polish edition was published in 1993, after Sword of Destiny.", authorAS);
        Libro theWitcher2 = new Libro("1B", "Sword of Destiny", "Sword of Destiny is the second book in Andrzej Sapkowski's The Witcher series in terms of story chronology.", authorAS);
        Libro callOfCthulhu = new Libro("2A", "The Call of Cthulhu and Other Weird Stories", " The Call of Cthulhu and Other Weird Stories is Penguin Classics' first omnibus edition of works by seminal 20th-century American author H. P. Lovecraft.", authorHPL);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.insertBook(authorAS, theWitcher1);
        biblioteca.insertBook(authorAS, theWitcher2);
        biblioteca.insertBook(authorDG, metro2033);
        biblioteca.insertBook(authorDG, metro2034);
        biblioteca.insertBook(authorDG, metro2035);


    }
}
