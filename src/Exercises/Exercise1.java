package Exercises;

import java.util.*;

public class Exercise1 {

    public static <T> void reverseArrayListInPlace(ArrayList<T> list){
        if(list.isEmpty()){
            return;
        }
        else{
            T element = list.remove(0);
            reverseArrayListInPlace(list);
            list.add(element);
        }

    }

    public static <E> LinkedList<E> reverseLinkedList(LinkedList<E> list){
        LinkedList<E> l = new LinkedList<E>();

        for(E element : list){
            l.addFirst(element);
        }

        return l;
    }

    public static <E> void reverseLinkedListInPlace(LinkedList<E> list){
        if(list.isEmpty()){
            return;
        }
        else{
            E element = list.remove(0);
            reverseLinkedListInPlace(list);
            list.add(element);
        }
    }


    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        reverseLinkedListInPlace(list);
        System.out.print(list.toString());


    }
}
