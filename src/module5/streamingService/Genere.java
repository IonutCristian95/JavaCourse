package module5.streamingService;

public enum Genere {
    HORROR("Horror"),
    ACTION("Action"),
    COMEDY("Comedy"),
    THRILLER("Thriller"),
    DOCUMENTARY("Documentary"),
    WAR("War"),
    NOIR("Noir"),
    FANTASY("Fantasy"),
    DRAMA("Drama");

    private String genere;

    Genere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return genere;
    }
}
