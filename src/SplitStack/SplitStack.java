package SplitStack;

import java.util.*;

public class SplitStack {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(5, -5, 67, -45, 67, 9, 0, -42, 56, -7));//test case

        Stack<Integer> stack = new Stack<Integer>();

        for (int x : list) { //pushes the integers from list above into stack
            stack.push(x);
        }

        System.out.println(splitStack(stack));//runs the splitStack method created
    }
    public static Stack splitStack(Stack<Integer> s) {
        Stack<Integer> stack = new Stack<Integer>(); //creates a new empty stack

        List<Integer> neg = new ArrayList<Integer>();//a list to hold the negative and positive integers
        List<Integer> pos = new ArrayList<Integer>();

        while(!s.isEmpty()) { //runs while the stack is not empty and check is the int is less than zero, if true, it places it into the negative list.
            if(s.peek() < 0){
                neg.add(s.peek());
            }
            stack.push(s.pop());
        }

        while(!stack.isEmpty()) { //runs while the stack is not empty and check is the int is greater than or equal to zero, if true, it places it into the positive list.
            if(stack.peek() >= 0){
                pos.add(stack.peek());
            }
            s.push(stack.pop());
        }

        for(int x: neg){ //pushes the negatives numbers onto the stack.
            stack.push(x);
        }

        for(int x: pos){ //pushes the positive numbers onto the stack.
            stack.push(x);
        }

        return stack; //returns the stack with positive and negative integers seperated.
    }
}


