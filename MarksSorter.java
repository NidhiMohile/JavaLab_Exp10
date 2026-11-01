import java.util.Arrays;
import java.util.Scanner;

public class MarksSorter {
    
    // Selection Sort Implementation
    public static void selectionSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            double temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort Implementation
    public static void insertionSort(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            double key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Student Marks Sorting System ===");
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        double[] marks = new double[n];
        
        System.out.println("Enter the student marks:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextDouble();
        }

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Sort using Selection Sort");
            System.out.println("2. Sort using Insertion Sort");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();

            // Create a copy so original input remains intact for subsequent selections
            double[] tempMarks = Arrays.copyOf(marks, marks.length);

            if (choice == 1) {
                selectionSort(tempMarks);
                System.out.println("Sorted Marks (Selection Sort): " + Arrays.toString(tempMarks));
            } else if (choice == 2) {
                insertionSort(tempMarks);
                System.out.println("Sorted Marks (Insertion Sort): " + Arrays.toString(tempMarks));
            } else if (choice == 3) {
                System.out.println("Exiting program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice! Please enter a valid option between 1 and 3.");
            }
        }
        scanner.close();
    }
}