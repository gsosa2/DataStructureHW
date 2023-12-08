package Exercises;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Exercise4{

    public class MyQueue<E> {
        private LinkedList<E> backingList;

        public void add(E e) {
            backingList.addFirst(e);
        }

        public E remove() throws NoSuchElementException {
            if (backingList.isEmpty()) {
                throw new NoSuchElementException();
            }
            return backingList.removeFirst();

        }

        public E PeekHead() throws NoSuchElementException {
            if (backingList.isEmpty()) {
                throw new NoSuchElementException();
            }
            return backingList.peekFirst();

        }

        public E PeekTail() throws NoSuchElementException {
            if (backingList.isEmpty()) {
                throw new NoSuchElementException();
            }
            return backingList.peekLast();

        }
    }




}
