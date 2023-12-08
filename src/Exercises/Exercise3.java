package Exercises;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class Exercise3<E> {

    public class MyStack<E> {
        private LinkedList<E> backingList;

        public MyStack() {
            Stack<E> list = new Stack<E>();
        }

        public void push(E e) {
            backingList.addLast(e);
        }

        public E pop(E e) throws EmptyStackException {
            if (backingList.isEmpty()) {
                throw new EmptyStackException();
            } else {
                backingList.removeFirst();
                return e;
            }
        }

        public E peek(E e) throws EmptyStackException {
            if (backingList.isEmpty()) {
                throw new EmptyStackException();
            } else {
                return e;
            }

        }
    }

}
