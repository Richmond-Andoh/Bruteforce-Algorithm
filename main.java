package Bruteforce;

import java.util.Scanner;

public class main {
    
    // Brute force search for a target number in an array
    public static int bruteForceSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found the target, return its index
            }
        }
        return -1; // Target not found
    }

    // Exhaustive search for the maximum sum subarray (brute force method)
    public static int maxSubArraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    // Method to compute the running time of a given algorithm
    public static long measureTime(Runnable algorithm) {
        long startTime = System.nanoTime();
        algorithm.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Main method to allow user interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] exampleArray = {3, -2, 5, -1, 6, -3, 2, 7, -5};

        while (true) {
            System.out.println("Choose an algorithm to run:");
            System.out.println("1. Brute force search for a target number in an array");
            System.out.println("2. Exhaustive search for the maximum sum subarray");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            if (choice == 3) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the target number: ");
                    int target = scanner.nextInt();
                    Runnable searchTask = () -> bruteForceSearch(exampleArray, target);
                    long searchTime = measureTime(searchTask);
                    int searchResult = bruteForceSearch(exampleArray, target);
                    System.out.println("Target found at index: " + searchResult);
                    System.out.println("Running time (nanoseconds): " + searchTime);
                    System.out.println("Theoretical time complexity: O(n)");
                    break;

                case 2:
                    Runnable maxSumTask = () -> maxSubArraySum(exampleArray);
                    long maxSumTime = measureTime(maxSumTask);
                    int maxSumResult = maxSubArraySum(exampleArray);
                    System.out.println("Maximum sum subarray: " + maxSumResult);
                    System.out.println("Running time (nanoseconds): " + maxSumTime);
                    System.out.println("Theoretical time complexity: O(n^3)");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

