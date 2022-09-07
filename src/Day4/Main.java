package Day4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Contatore
//        Contatore contatoreObj = new Contatore();
//        System.out.println(contatoreObj.getConteggio());
//        contatoreObj.incrementConteggio();
//        System.out.println(contatoreObj.getConteggio());
//        contatoreObj.resetConteggio(5);
//        System.out.println(contatoreObj.getConteggio());
//        contatoreObj.resetConteggio();
//        System.out.println(contatoreObj.getConteggio());

        //Quadrato
//        Quadrato quadrato = new Quadrato(4);
//        System.out.println(quadrato.getPerimeter());
//        quadrato.printQuadrato();

        //Cerchio
//        Cerchio cerchio = new Cerchio(8);
//        System.out.println(cerchio.getCircumference());
//        System.out.println(cerchio.getArea());

        //Lampadina
        Corrente corrente = Corrente.STACCARE;
        Lampadina lampadina = new Lampadina(1, corrente);
        Lampadina lampadina1 = new Lampadina(5, corrente);
        System.out.println("Lampadina: " + lampadina.stato()); //SPENTA
        System.out.println("Lampadina1: " + lampadina1.stato()); //SPENTA


        lampadina.click();
        lampadina1.click();
        System.out.println("Lampadina: " + lampadina.stato()); //ACCESA
        System.out.println("Lampadina1: " + lampadina1.stato()); //ACCESA


        corrente.staccareRiattacareImpianto(); // STACCARE
        System.out.println("Lampadina: " + lampadina.stato()); //SPENTA
        System.out.println("Lampadina1: " + lampadina1.stato()); //SPENTA


        lampadina.click();
        corrente.staccareRiattacareImpianto(); //ATTACCARE
        System.out.println("Lampadina: " + lampadina.stato()); //ROTTA
        System.out.println("Lampadina1: " + lampadina1.stato()); //ACCESA

//        usaLampadina(lampadina);

        
        //Biblioteca
//        int[] values = new int[7];
//        values[0] = 123;
//        values[1] = 4;
//        values[2] = 98;
//        values[3] = 33;
//        values[4] = 76;
//        values[5] = 2;
//        values[6] = 235;
//        Biblioteca library = new Biblioteca(values);
//        System.out.println("Esiste libro: " + library.esisteLibro(76));
//        int[] libriOrdinati = library.getIndiciLibriOrdinati();
//        System.out.println(libriOrdinati[0] == 2);
//        System.out.println(libriOrdinati[1] == 4);
//        System.out.println(libriOrdinati[2] == 33);
//        System.out.println(libriOrdinati[3] == 76);
//        System.out.println(libriOrdinati[4] == 98);
//        System.out.println(libriOrdinati[5] == 123);
//        System.out.println(libriOrdinati[6] == 235);
    }

    private static void usaLampadina(Lampadina lampadina){
        Interruttore interruttore1 = new Interruttore(lampadina);
        Interruttore interruttore2 = new Interruttore(lampadina);
        Scanner scanner = new Scanner(System.in);

        int interruttoreInt = 0;
        while(true){
            System.out.println("Quale interruttore premi? 1 / 2");
            interruttoreInt = scanner.nextInt();

            switch (interruttoreInt){
                case 1 : interruttore1.click();
                break;
                case 2 : interruttore2.click();
                break;
                default:
                    System.out.println("Exit");
                    return;
            }
        }
    }

}
