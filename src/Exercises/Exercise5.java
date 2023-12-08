package Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Exercise5 {
    public static boolean isBalanced2(String parentheses){

        Stack<Character> stack = new Stack<Character>();

        char[] paraArray = parentheses.toCharArray();

        for(int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) { //if the first is a closing bracket it cannot be balance so this checks for that and returns false.
                return false;
            }
            char check;
            switch (c) {
                case ')' -> {
                    check = stack.pop();
                    if (check == '{' || check == '[') {
                        return false;
                    }
                }
                case '}' -> {
                    check = stack.pop();
                    if (check == '(' || check == '[') {
                        return false;
                    }
                }
                case ']' -> {
                    check = stack.pop();
                    if (check == '(' || check == '{') {
                        return false;
                    }
                }
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args){

        System.out.println(isBalanced2("(]"));
        System.out.println(isBalanced2("())"));
        System.out.println(isBalanced2("{()}"));




    }
}
