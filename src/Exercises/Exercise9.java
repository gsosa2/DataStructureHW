package Exercises;

import java.util.Arrays;

public class Exercise9 {
    public static <T extends Comparable<? super T>> void selectionSort(T[] A){
        int n = A.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (A[j].compareTo(A[min_idx]) < 0)
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            T temp = A[min_idx];
            A[min_idx] = A[i];
            A[i] = temp;
        }

    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] A){
        int n = A.length;
        for (int i = 1; i < n; ++i) {
            T key =A[i];
            int j = i - 1;

            while (j >= 0 && A[j].compareTo(key) > 0) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = key;
        }
    }
    public static <T extends Comparable<? super T>> void bubbleSort(T[] A) {
        int n = A.length;
        T temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (A[j - 1].compareTo(A[j]) > 0) {
                    temp = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = temp;
                }
            }

        }
    }

   public static <T extends Comparable<? super T>> void mergeSort(T[] A){

       int n = A.length;
       if (n > 1) {
           int mid = n / 2;
           T[] left = Arrays.copyOfRange(A, 0, mid);
           T[] right = Arrays.copyOfRange(A, mid, n);

           mergeSort(left);
           mergeSort(right);

           merge(A, left, right);
       }
    }
    public static <T extends Comparable<? super T>> void heapSort(T[] A) {
        int n = A.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            heapify(A, i, 0);
        }
    }

    private static <T extends Comparable<? super T>> void heapify(T[] A, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && A[left].compareTo(A[largest]) > 0) {
            largest = left;
        }

        if (right < n && A[right].compareTo(A[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            heapify(A, n, largest);
        }
    }

    public static <T extends Comparable<? super T>> void merge(T[] a, T[] left, T[] right){
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if((left[i].compareTo(right[j])) <= 0) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
            }
            k++;
        }

        while( i < left.length){
            a[k] = left[i];
            i++;
            k++;
        }

        while( j < right.length){
            a[k] = right[j];
            j++;
            k++;
        }


    }
    public static <T extends Comparable<? super T>> void quickSort(T[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] A, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(A, low, high);

            quickSort(A, low, partitionIndex - 1);
            quickSort(A, partitionIndex + 1, high);
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] A, int low, int high) {
        T pivot = A[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (A[j].compareTo(pivot) <= 0) {
                i++;

                T temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        T temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }
}
