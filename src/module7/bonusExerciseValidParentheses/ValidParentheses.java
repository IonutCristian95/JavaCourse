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

        Map<Integer, Character> openParentheses = Stream.of(new Object[][] {
                { 0, '('},
                { 1, '['},
                { 2, '{'}
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (Character) data[1]));

        Map<Character, Integer> closeParentheses = Stream.of(new Object[][] {
                { ')', 0},
                { ']', 1},
                { '}', 2}
        }).collect(Collectors.toMap(data -> (Character) data[0], data -> (Integer) data[1]));

        try{
            for(int counter = 0; counter < string.length(); counter++){
                if (closeParentheses.containsKey(string.charAt(counter)) &&
                        stack.peek().equals(openParentheses.get(closeParentheses.get(string.charAt(counter))))){
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
