package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class Esercizi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Esercizio 1
//        System.out.print("Enter character a:");
//        String a = scanner.nextLine();
//        System.out.print("Enter string b:");
//        String b =scanner.nextLine();
//        countOccurrences(a.charAt(0), b);

        //Esercizio 2
//        System.out.print("Enter string:");
//        String a2 = scanner.nextLine();
//        stringReverse(a2);


        //Esercizio 3
//        int number = 0;
//        System.out.println(isPrime(number));
//        number = 1;
//        System.out.println(isPrime(number));
//        number = 2;
//        System.out.println(isPrime(number));
//        number = 17;
//        System.out.println(isPrime(number));
//        number = 631;
//        System.out.println(isPrime(number));
//        number = 634;
//        System.out.println(!isPrime(number));
//        number = 999;
//        System.out.println(!isPrime(number));
//        number = 997;
//        System.out.println(isPrime(number));

        //Esercizio 4
//        System.out.println(factorial(1) == (0));
//        System.out.println(factorial(2) == (2));
//        System.out.println(factorial(5) == (120));
//        System.out.println(factorial(10) == (3628800));
//        System.out.println(factorial(20) == 2432902008176640000L);

        //Esercizio 5
//        System.out.println(harmonicSum(0) == (0));
//        System.out.println(harmonicSum(1) == (1));
//        System.out.println(harmonicSum(2) == (3./2));
//        System.out.println(harmonicSum(20) == (55835135./15519504));

        //Esercizio 6
        System.out.println(isPalindrome("c"));
        System.out.println(isPalindrome("ciic"));
        System.out.println(isPalindrome("aaaa"));
        System.out.println(!isPalindrome("absca"));
        System.out.println(!isPalindrome("abbaa"));
        System.out.println(isPalindrome("zzzzz"));
        System.out.println(isPalindrome("zzczz"));
        System.out.println(isPalindrome("aabbaa"));
    }

    private static void countOccurrences(char lit, String stringa){
//        int numOccurrences = 0;
//        for(int counter = 0; counter < stringa.length(); counter++){
//            if(stringa.charAt(counter) == lit){
//                numOccurrences++;
//            }
//        }
//        System.out.println(numOccurrences);


        int lengthBefore = stringa.length();
        stringa = stringa.replaceAll(String.valueOf(lit), "");

        System.out.println(lengthBefore-stringa.length());
    }

    public static void stringReverse(String s) {
        String temp = "";
        for(int i = s.length()-1; i >= 0; i--){
            temp += s.charAt(i);
        }
        System.out.println(temp);
    }

    private static boolean isPrime(int number) {
        if(number <= 1) {
            return false;
        }
        for(int i = 2; i < number/2; i++){
            if(number % i == 0) return false;
        }
        return true;
    }


    private static long factorial(int n) {
        if(n == 0) return 1;

        long result=n;
        for(int i = n-1; i > 0; i--){
            result *= i;
        }
        return result;
    }

    private static double harmonicSum(int n) {
        if(n == 0) return 0;

        double result = 1;

        for (int i = 2; i <= n; i++){
            result += (1.00/i);
        }

        return result;
    }

    private static boolean isPalindrome(String s) {
        for(int start = 0, end = s.length()-1; start<=s.length()/2; start++, end--){
            if(s.charAt(start)==s.charAt(end))
                continue;
            return false;
        }
        return true;
    }

}
