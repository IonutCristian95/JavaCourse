package module7.Supermarket;

public class Main {
    public static void main(String[] args) {
        CodaOrdinata coda = new CodaOrdinata();

        Cliente client1 = new Cliente("Marco", "Rossi", 45, 1);
        Cliente client2 = new Cliente("John", "Smith", 20, 2);
        Cliente client3 = new Cliente("Fillipe", "Test", 81, 3);
        Cliente client4 = new Cliente("Mark", "Smith", 18, 4);

        coda.addClientQueue(client1);
        coda.addClientQueue(client2);
        coda.addClientQueue(client3); // 81 years old
        coda.addClientQueue(client4);

        coda.printCoda();

        coda.getNextClient();
        coda.removeClient(client4);
        coda.getNextClient();
        System.out.println(coda.size());

        coda.getNextClient();
        System.out.println(coda.size());



        coda.addClientQueue(client1);
        coda.addClientQueue(client2);
        coda.addClientQueue(client3);
        coda.addClientQueue(client4);
        coda.printCoda();
        coda.orderCoda();
    }
}
