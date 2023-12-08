package Exercises;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class Exercise10 {

    static class Student {
        String lastName;
        String firstName;
        int section;

        public Student(String firstName, String lastName, int section) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.section = section;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public int getSection() {
            return section;
        }

        public void setSection(int section) {
            this.section = section;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "lastName='" + firstName + '\'' +
                    ", firstName='" + lastName + '\'' +
                    ", section=" + section +
                    '}';
        }

    }

    public static <T> void selectSort(T[] A, Comparator<T> cmp) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (cmp.compare(A[j], A[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = A[i];
                A[i] = A[minIndex];
                A[minIndex] = temp;
            }
        }
    }

    public static <T> void insertionSort(T[] A, Comparator<T> cmp) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            T key = A[i];
            int j = i - 1;
            while (j >= 0 && cmp.compare(A[j], key) > 0) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }

    public static <T> void bubbleSort(T[] A, Comparator<T> cmp) {
        int n = A.length;
        T temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (cmp.compare(A[j], A[j + 1]) > 0) {
                    temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    public static <T> void heapSort(T[] A, Comparator<T> cmp) {
        int n = A.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i, cmp);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            heapify(A, i, 0, cmp);
        }
    }

    private static <T> void heapify(T[] A, int n, int i, Comparator<T> cmp) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && cmp.compare(A[left], A[largest]) > 0) {
            largest = left;
        }

        if (right < n && cmp.compare(A[right], A[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            heapify(A, n, largest, cmp);
        }
    }

    public static <T> void mergeSort(T[] A, Comparator<T> cmp) {
        int n = A.length;
        if (n > 1) {
            int mid = n / 2;
            T[] left = Arrays.copyOfRange(A, 0, mid);
            T[] right = Arrays.copyOfRange(A, mid, n);

            mergeSort(left, cmp);
            mergeSort(right, cmp);

            merge(A, left, right, cmp);
        }
    }

    private static <T> void merge(T[] A, T[] left, T[] right, Comparator<T> cmp) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (cmp.compare(left[i], right[j]) <= 0) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }

        while (i < left.length) {
            A[k++] = left[i++];
        }

        while (j < right.length) {
            A[k++] = right[j++];
        }
    }

    public static <T> void quickSort(T[] A, Comparator<T> cmp) {
        quickSort(A, 0, A.length - 1, cmp);
    }

    private static <T> void quickSort(T[] A, int low, int high, Comparator<T> cmp) {
        if (low < high) {
            int partitionIndex = partition(A, low, high, cmp);

            quickSort(A, low, partitionIndex - 1, cmp);
            quickSort(A, partitionIndex + 1, high, cmp);
        }
    }

    private static <T> int partition(T[] A, int low, int high, Comparator<T> cmp) {
        T pivot = A[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (cmp.compare(A[j], pivot) <= 0) {
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

    public static void main(String[] args){

        Student[] students = {
                new Student("John", "Neubacher", 3),
                new Student("Ilya", "Lessing", 1),
                new Student("Nabeel", "Aronowitz", 3),
                new Student("Joe", "Jones", 2),
                new Student("Katie", "Senya", 1),
                new Student("John", "Alisson", 2),
                new Student("Betty", "Neubacher", 2),
                new Student("James", "Ledbetter", 2),
                new Student("Betty", "Lipschitz", 2),
                new Student("Ping", "Yi", 1),
                new Student("Jim", "Smith", 3)
        };
        Comparator<Student> cmp = Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName);

        Comparator<Student> cmp2 = Comparator.comparing(Student::getSection);

        Arrays.sort(students, cmp);

        System.out.println(Arrays.toString(students));

        System.out.println("Original Array:");
        Arrays.stream(students).forEach(System.out::println);

        selectSort(students, cmp);

        System.out.println( "\n" + "Select Sort:");

        Arrays.stream(students).forEach(System.out::println);

        bubbleSort(students, cmp);

        System.out.println( "\n" + "Bubble Sort:");

        Arrays.stream(students).forEach(System.out::println);

        insertionSort(students, cmp);

        System.out.println( "\n" + "Insertion Sort:");

        Arrays.stream(students).forEach(System.out::println);

        heapSort(students, cmp);

        System.out.println( "\n" + "Heap Sort:");

        Arrays.stream(students).forEach(System.out::println);

        mergeSort(students, cmp);

        System.out.println( "\n" + "Merge Sort:");

        Arrays.stream(students).forEach(System.out::println);

        quickSort(students, cmp);

        System.out.println( "\n" + "Quick Sort:");

        Arrays.stream(students).forEach(System.out::println);


    }

}
