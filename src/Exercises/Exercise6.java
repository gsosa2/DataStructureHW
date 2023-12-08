package Exercises;

import java.util.*;

public class Exercise6{

    public static <E> List<E> kSmallest(List<E> A, int k, Comparator<E> cmp){

        PriorityQueue<E> queue = new PriorityQueue<E>(cmp);
        queue.addAll(A);

        List<E> result = new ArrayList<E>();

        for(int i = 0; i <= k; i++){
            result.add(queue.remove());
        }


        return result;
    }


    public static void main(String[] args){

        List<Integer> inputList = List.of(4, 2, 7, 1, 9, 3, 6);
        int k = 3;

        Comparator<Integer> comparator = Comparator.naturalOrder();
        List<Integer> result = kSmallest(inputList, k, comparator);

        System.out.println(kSmallest(inputList,k,comparator));


    }

}
