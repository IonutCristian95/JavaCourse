package module8Exceptions.ex3_DivisionBy0;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        try {
            System.out.println("Type an integer: ");
            int number = scanner.nextInt();
            int counter = 0;

            while (counter < 10) {
                System.out.println("Result: " + (number / Math.abs((rand.nextInt() % 4))));
                counter++;
            }

        } catch (ArithmeticException e) {
            System.out.println("Error: Artihmetic exception " + e);
        } catch(InputMismatchException i){
            System.out.println("Has to be an integer: " + i);
        }finally {
            scanner.close();
        }
    }
}
