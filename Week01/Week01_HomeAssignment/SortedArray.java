package Week01;
import java.util.Scanner; 
import java.util.Arrays;

public class SortedArray {
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Enter the number of elements in the array: "); 
        int n = scanner.nextInt(); 

        int[] arr = new int[n]; 

        System.out.println("Enter the elements of the array: "); 
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt(); 
        }

        // Sắp xếp
        Arrays.sort(arr); 

        // Tính tổng & Trung bình

        int S = 0; 
        for (int x : arr) {
            S += x; 
        }
        double average = (double) S / n; 

        // In ra mảng đã sắp xếp
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Sum of array elements: " + S); 
        System.out.println("Average value: " + average); 

        scanner.close(); 
    }



}
