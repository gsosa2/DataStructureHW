package Exercises;

import java.util.List;
import java.util.ListIterator;

public class Exercise2 {

    public static <E> void add(List<E> list, int index, E element) throws IndexOutOfBoundsException{
        if(index < 0 || index > list.size()){
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            list.set(index, element);
        }

    }

    public static <E> E remove(List<E> list, int index) throws IndexOutOfBoundsException{
        ListIterator<E> iter = list.listIterator();
        if (index < 0 || index > list.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
            int i = 0;
            while (iter.hasNext() && i < index) {
                iter.next();
                i++;
            }
            E item = iter.next();
            iter.remove();
            return item;
        }

    public static <E> E get(List<E> list, int index){
        ListIterator<E> iter = list.listIterator();
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0; 		while (iter.hasNext() && i < index) {
            iter.next();
            i++;
        }
        return iter.next();
    }

    public static <E> void set(List<E> list, int index, E element){
        ListIterator<E> iter = list.listIterator();
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        while (iter.hasNext() && i < index){
            iter.next(); 			i++;
        }
        iter.set(element);
    }

    public static <E> int indexOf(List<E> list, E element){
        ListIterator<E> iter = list.listIterator();
        int i = 0;
        while (iter.hasNext()){
            E e = iter.next();
            if (e.equals(element)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <E> int lastIndexOf(List<E> list, E element){
        ListIterator<E> iter = list.listIterator();
        while (iter.hasNext()){
            iter.next();
        }
        int i = 0;
        while (iter.hasPrevious()){
            E e = iter.previous();
            if (e.equals(element)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <E> boolean remove(List<E> list, E element){
        ListIterator<E> iter = list.listIterator();
        while (iter.hasNext()){
            E e = iter.next();
            if (e.equals(element)){
                iter.remove();
                return true;
            }
        }
        return false;
    }

    public static <E> boolean equals(List<E> list1, List<E> list2){
        ListIterator<E> iter1 = list1.listIterator();
        ListIterator<E> iter2 = list2.listIterator();
        if (list1.size() != list2.size()){
            return false;
        }
        while (iter1.hasNext() && iter2.hasNext()){
            E e1 = iter1.next();
            E e2 = iter2.next();
            if (!(e1.equals(e2))){
                return false;
            }
        }
        return true;
    }
}






