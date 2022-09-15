package module8Exceptions.ex2_NullPointer;

public class Main {
    public static void main(String[] args) {
        try{
            String stringa = null;
            int lunghezza = stringa.length();
        }catch(NullPointerException e){
            System.out.println(e);
        }
    }
}
