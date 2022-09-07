package module5.gestoreVeicoli;

public class Main {
    public static void main(String[] args) {
        AutoMobile automobile = new AutoMobile("cf123rm", 4, 4);
        AutoCarro autoCarro = new AutoCarro("ca133sm", 4, 2);

        System.out.println("autoCarro " + autoCarro);
        System.out.println("automobile " + automobile);
    }
}
