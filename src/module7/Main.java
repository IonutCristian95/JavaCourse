package module7;

public class Main {
    public static void main(String[] args) {
        Coda coda = new Coda();

        Cliente client1 = new Cliente("Marco", "Rossi", 45, 1);
        Cliente client2 = new Cliente("John", "Smith", 20, 2);
        Cliente client3 = new Cliente("Fillipe", "Test", 81, 3);
        Cliente client4 = new Cliente("Mark", "Smith", 18, 5);

        coda.addClientQueue(client1);
        coda.addClientQueue(client2);
        coda.addClientQueue(client4);
        coda.addClientQueue(client3); // 81 years old - priority queue - To Do

        coda.getNextClient();
        coda.removeClient(client4);
        coda.getNextClient();
        System.out.println(coda.getSizeCoda());

        coda.getNextClient();
        System.out.println(coda.getSizeCoda());
    }
}
