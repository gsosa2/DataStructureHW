package Exercises;

import java.util.Arrays;
import java.util.Random;

public class Exercise8 {

    private static long x;
    private static long y;

    public static long closestPairBruteForce(long[] A) {

        long closestDistance = Long.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    if (Math.abs(A[i] - A[j]) < closestDistance) {
                        closestDistance = Math.abs(A[j] - A[i]);
                        x = A[i];
                        y = A[j];
                    }
                }
            }
        }
        return closestDistance;

    }

    public static long closestPairSort(long[] A) {

        Arrays.sort(A);

        long closestDistance = Long.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            long difference = Math.abs(A[i + 1] - A[i]);
            closestDistance = Math.min(difference, closestDistance);
        }

        return closestDistance;

    }

    public static void main(String[] args) {

        long[] randomLongArray = new long[100000];

        // Creating a Random object
        Random random = new Random();

        // Populating the array with random long values
        for (int i = 0; i < randomLongArray.length; i++) {
            randomLongArray[i] = random.nextLong();
        }

        // Printing a few values for demonstration
        long[] longArray = {1L, 20L, 5L, 10L, 8L, 13L, 25L, 30L, 100L};

        long[] test = {1000, 10000, 100000, 1000000};
        System.out.println("The closest distance is " + closestPairSort(randomLongArray) + " from the long " + x + " and " + y);


        System.out.println("The closest distance is " + closestPairBruteForce(randomLongArray) + " from the long " + x + " and " + y);



    }
}
