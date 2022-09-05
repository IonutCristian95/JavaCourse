package Day1;

import java.util.Arrays;
import java.util.Scanner;

public class Esercizi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Esercizio 1
//
//        int numero1;
//        int numero2;
//
//        System.out.println("Enter first number: ");
//        numero1 = scanner.nextInt();
//        System.out.println("Enter second number: ");
//        numero2 = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Add " + (numero1+numero2));
//        System.out.println("Subtraction " + (numero1-numero2));
//        System.out.println("Multiply " + (numero1*numero2));
//        System.out.println("Division " + (numero1/numero2));

//        Esercizio 2

//        System.out.println("Enter a number: ");
//        int numero3 = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println((numero3 % 2) == 0);



        //Esercizio 3

//        String s = scanner.nextLine();
//        String[] temp = s.split(" ");
//        System.out.println(temp[1]+ " " + temp[0]);
//
//        int spacePosition = s.indexOf(" ");
//        System.out.println(s.substring(spacePosition+1, s.length()) + " " + s.substring(0, spacePosition));

        //Esercizio 4
//
//        String a = scanner.nextLine();
//        String b = scanner.nextLine();
//        String c = scanner.nextLine();
//
//
//        String[] temp = c.split(" ");
//        String central = (temp[1]).replace(a, b);
//        System.out.println(temp[0] + " "+ central + " " +  temp[2]);


        //Esercizio 5
//
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String c = scanner.nextLine();


        if(a.equalsIgnoreCase(b) && a.equalsIgnoreCase(c)) System.out.println(3);
        else if(a.equalsIgnoreCase(b) || b.equalsIgnoreCase(c) || a.equalsIgnoreCase(c)) System.out.println(2);
        else System.out.println(0);
    }
}
