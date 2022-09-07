package Day5;

public enum Directions {
    W("w"),
    A("a"),
    S("s"),
    D("d");

    private String direction;

    Directions(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
