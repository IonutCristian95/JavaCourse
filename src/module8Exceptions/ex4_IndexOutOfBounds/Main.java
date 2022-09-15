package module8Exceptions.ex4_IndexOutOfBounds;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int[] intArray = new int[5];
            for (int i = 0; i < intArray.length; i++) {
                System.out.println("Type an integer: ");
                intArray[i] = scanner.nextInt();
            }

            int counter = 0, value, position;
            while(counter < 10){
                System.out.println("Insert the value: ");
                value = scanner.nextInt();
                System.out.println("The position in the array: ");
                position = scanner.nextInt();
                insertNumber(intArray, value, position);
                System.out.println(Arrays.toString(intArray));
            }
        }catch (InputMismatchException i){
            System.out.println("Input mismatch exception: " + i);
        }catch (Exception e){
            System.out.println("Another exception occured: " + e);
        }

    }

    private static void insertNumber(int[] array, int value, int position){
        try{
            array[position] = value;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Caught in insertNumber method:");
            e.printStackTrace();
        }
    }

}
