package module7.bonusExerciseValidParentheses;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidParentheses {
    public static void main(String[] args) {
        String temp = "()";
        String temp2 = "()[]{}";
        String temp3 = "[}";
        String temp4 = "[({}{}(){})]";
        String temp5 = "}(){[]}";//exception
        String temp6 = "()}{[]}";//exception

        System.out.println(isValid(temp));
        System.out.println(isValid(temp2));
        System.out.println(isValid(temp3));
        System.out.println(isValid(temp4));
        System.out.println(isValid(temp5));
        System.out.println(isValid(temp6));
    }

    private static boolean isValid(String string){
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> parentheses = Stream.of(new Object[][] {
                { ')', '('},
                { ']', '['},
                { '}', '{'}
        }).collect(Collectors.toMap(data -> (Character) data[0], data -> (Character) data[1]));

        try{
            for(int counter = 0; counter < string.length(); counter++){
                if (parentheses.containsKey(string.charAt(counter)) &&
                        stack.peek().equals(parentheses.get(string.charAt(counter)))){
                    stack.pop();
                }else{
                    stack.add(string.charAt(counter));
                }
            }
        }catch (EmptyStackException e){
            System.out.println("Not Valid");
            return false;
        }


        return stack.empty();
    }
}
