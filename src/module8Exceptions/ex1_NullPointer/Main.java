package module8Exceptions.ex1_NullPointer;

public class Main {
    public static void main(String[] args) {
        try{
            int[] array = null;
            array[0] = 1;
        }catch(NullPointerException e){
            System.out.println("Error " + e);
        }
    }
}
