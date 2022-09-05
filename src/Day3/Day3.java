package Day3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Esercizio 1
//        System.out.println("Secondi: ");
//        long secondi = scanner.nextInt();
//        scanner.nextLine();
//        secondiConverter(secondi);

        //Esercizio 2
//        System.out.println("Int Array: (usa ',':  1,2,3,... )");
//        String[] stringArray = scanner.nextLine().split(",");
//
//        System.out.println(Arrays.toString(dispariArray(stringArray)));

//        //Esercizio 3
//        int numeroFacce = 6;
//        System.out.println(lanciaDado(numeroFacce));

        //Esercizio 4
//        System.out.println("Inserisci il numero: ");
//        int num = scanner.nextInt();
//        System.out.println("Inserisci il numero di colonne: ");
//        int col = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println(Arrays.toString(tabelline(num, col)));

        //Esercizio 5
//        System.out.print("Enter index:");
//        int index =scanner.nextInt();
//        fibonacci(index);

        //Esercizio 6
//        System.out.print("Enter numbers (comma-separated):");
//        String a = scanner.nextLine();
//        int[] values = parseNumbers(a);
//        computeMinAndMax(values);
        
        //Esercizio 7
//        System.out.print("Enter string a:");
//        String a = scanner.nextLine();
//        System.out.print("Enter string b:");
//        String b =scanner.nextLine();
//        anagrams(a, b);

//        Esercizio 8
        System.out.println("Insert names: ");
        String input = scanner.nextLine();
        System.out.println(stringExtractor(input));

        //Bonus
        //Test1
//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = 3;
//        merge(nums1, m, nums2, n);
        //Test2
//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1,3};
//        int n = 2;
//        merge(nums1, m, nums2, n);

        scanner.close();
    }

    //Esercizio 1
//    Scrivete una funzione che dato in input un numero di secondi, restituisce una
//    stringa che dice «Giorni: numero di giorni, Ore: numero di ore etc…
    private static void secondiConverter(long secondsInput){
        long temp = secondsInput;
        short giorni = 0;
        byte ore = 0;
        byte minuti = 0;
        byte secondi = 0;

        if(temp >= 86400){
            giorni = (short) (temp/86400);
            temp -= (giorni*86400);
        }
        if(temp >= 3600){
            ore = (byte)(temp/3600);
            temp -= (ore*3600);
        }
        if(temp >= 60){
            minuti = (byte)(temp/60);
            temp-=(minuti*60);
        }
        if(temp > 0){
            secondi = (byte)temp;
        }
        System.out.println("Giorni: " + giorni + " Ore: " + ore + " Minuti: " + minuti + " Secondi: " + secondi);
    }

    //Esercizio 2
//    Scrivete una funzione che dato un array di valori ne restituisce una copia dove i
//    numeri dispari sono stati moltiplicati per 2
    private static int[] dispariArray(String[] stringArray){
        int[] proto = new int[stringArray.length];

        for(int i = 0; i < stringArray.length; i++){
            proto[i] = Integer.parseInt(stringArray[i]);
        }

        int temp = 0;
        for(int i = 0; i < proto.length; i++){
            temp = proto[i];
            if(temp%2==1){
                proto[i] = temp*2;
            }
        }
        return proto;
    }

    //Esercizio 3
//  Non tutti i dadi hanno 6 facce! Per ogni evenienza vogliamo simulare il lancio di
//  un dado con un numero arbitrario di facce
//• Scrivete un programma che estrae casualmente un valore da un dado ad n facce
//  (un intero compreso tra 1 e n)
    private static int lanciaDado(int numeroFacce)
    {
        Random rand = new Random();
        int temp = 1+(rand.nextInt()%numeroFacce);
        return (temp < 0) ? temp*(-1) : temp;
    }

//Esercizio 4
//    Scrivete una funzione che dato in input due numeri n ed m, crea un array lungo m
//    che in ogni cella ha il valore di indice della cella moltiplicato per
    private static int[] tabelline(int n, int m){
        int[] temp = new int[m];
        for(int i = 0; i < m; i++){
            temp[i] = i*n;
        }
        return temp;
    }

//Esercizio 5
//    Scrivere un metodo che stampa l’ennesimo elemento della sequenza di Fibonacci, nella quale
//    ogni numero è definito dalla somma dei due precedenti, eccetto i primi due che sono per
//    definizione 0 e 1. Esempio: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ... E così via.
//    Assumete di iniziare da 0, dunque fibonacci(0) = 0, fibonacci(1) = 1, ... e così via
    static void fibonacci(int index) {
        if(index == 0) {
            System.out.println("Fibonacci("+ index + ") = " + 0);
            return;
        }else if(index == 1){
            System.out.println("Fibonacci("+ index + ") = " + 1);
            return;
        }
        int counter = 1;
        long a = 0;
        long b = 1;
        long temp;

        while(counter < index){
            temp = a + b;
            a = b;
            b = temp;
            counter++;
        }

        System.out.println("Fibonacci("+ index + ") = " + b);
    }

    //Esercizio 6
//    Dato un array di interi (inseriti dall’utente, separati da virgola e senza spazi), effettuare la
//    conversione dei valori in interi e stampare in ordine minimo e massimo (separati da virgola).
//    Gli interi inseriti possono anche assumere valori negativi
    private static int[] parseNumbers(String s) {
        String[] stringArray = s.split(",");
        int[] proto = new int[stringArray.length];

        for(int i = 0; i < stringArray.length; i++){
            proto[i] = Integer.parseInt(stringArray[i]);
        }
        return proto;
    }

    private static void computeMinAndMax(int[] values) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int var : values){
            if(var < min){
                min = var;
            }else if(var > max){
                max = var;
            }
        }
        System.out.println("Min: " + min + " Max: " + max);
    }


    //Esercizio 7
//    Due stringhe a e b sono dette anagrammi se contengono gli stessi caratteri con le stesse
//    frequenze. Ad esempio, gli anagrammi di CAT sono CAT, ACT, TAC, TCA, ATC, e CTA.
//    Date due stringhe a e b in input, stampare «anagrammi» se sono anagrammi (case-insensitive),
//    «non anagrammi» altrimenti.
    private static void anagrams(String a, String b) {
        if(a.length()!=b.length()){
            System.out.println("Non anagrammi");
            return;
        }

        a = a.toLowerCase();
        b = b.toLowerCase();

        Integer[] indexes = new Integer[a.length()];
        int counter = 0;
        for(String c : a.split("")){
            if(!b.contains(c)) {
                System.out.println("Non anagrammi");
                return;
            }
            else if(b.contains(c)){
                if(Arrays.asList(indexes).contains(b.indexOf(c))){
                    System.out.println("Non anagrammi");
                    return;
                }
                indexes[counter] = b.indexOf(c);
                counter++;
            }
        }

        System.out.println("Anagrammi");
    }

    //Another method to solve anagrams.
//private static void anagrams(String a, String b) {
//    String [] alpha = a.split("");
//    //System.out.println(Arrays.toString(alpha));
//    String [] beta = b.split("");
//
//    if(a.length()!=b.length()){
//        System.out.println("Non anagrammi");
//        return;
//    }
//
//    boolean found = false;
//    for (int i = 0; i < alpha.length; i++){
//        System.out.println(alpha[i]);
//        for (int j = 0; j < beta.length; j++){
//            if (alpha[i].equalsIgnoreCase(beta[j])){
//                found = true;
//                beta[j] = "";
//                break;
//            }
//        }
//
//        if (!found) {
//            System.out.println("Non anagrammi");
//            return;
//        }else{
//            //Reset il valore di boolean
//            found = false;
//        }
//    }
//    System.out.println("Anagrammi");
//}


//Esercizio 8
//    A partire da un array di stringhe, es. [‘Andrea’, ‘Marco’, ‘Melvin’, …], vogliamo
//    estrarre uno dei valori presenti in esso
//    Scrivete un programma che dato un array di stringhe, estrae casualmente una
//    delle stringhe
//    Provate a implementare diverse soluzioni del programma, utilizzando i diversi
//    metodi per estrarre un valore casuale e provando ad estrarre la stringa con una
//    probabilità non omogenea, es. ‘Andrea’ viene estratto il 50% delle volte, ‘Marco’
//    il 20%, …
    private static String stringExtractor(String proto){
        Scanner scanner = new Scanner(System.in);

        String[] string = proto.split(" ");
        Random rand = new Random();

        System.out.println("Enter your choice(int: Preferred position in the array): ");
        int arrayPositionPreferred = scanner.nextInt();
        scanner.nextLine();



        //Multiple extractions. Print with percentage
        int extractionLimit = scanner.nextInt();
        scanner.nextLine();

        int choice = 0;
        int counter = 0;
        System.out.println("Enter number of extractions: ");
        double[] extractions = new double[string.length];
        while(counter < extractionLimit){
            choice = (int) (arrayPositionPreferred + rand.nextGaussian());
            choice = (choice < 0) ? choice*(-1) : choice;
            extractions[choice] += 1;

            counter++;
        }

        for(int i = 0; i < string.length; i++){
            double percentage = (extractions[i]/extractionLimit)*100;
            System.out.println( string[i] + " viene estratto il " + percentage + "% delle volte");
        }
//        System.out.println(Arrays.toString(extractions));
//        System.out.println(Arrays.toString(string));

        return string[choice];
    }


    //Bonus
    //       You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n
//        representing the number of elements in nums1 and nums2 respectively.
//        Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//        The final sorted array should not be returned by the function, but instead be stored inside the array nums1
//        To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged
//        and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNums1 = nums1;
        nums1 = new int[m+n];

        int value;
        for(int counter = 0, nums1Position = 0, nums2Position = 0; counter < m+n; counter++){
            //In case one of them reaches the end, take all the values from the other one
            if(nums1Position >= m){
                nums1[counter] = nums2[nums2Position++];
                continue;
            }
            if(nums2Position >= n){
                nums1[counter] = tempNums1[nums1Position++];
                continue;
            }

             value = Math.min(tempNums1[nums1Position], nums2[nums2Position]);
            //Check in which array is the smallest value, and afterwards increment the counter position from that array
             if(value == tempNums1[nums1Position]){
                 nums1[counter] = value;
                 nums1Position++;
             }else if(value == nums2[nums2Position]){
                 nums1[counter] = value;
                 nums2Position++;
             }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
