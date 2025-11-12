import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount of numbers: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Enter " + n + " numbers:");

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        mergeSort(numbers, 0, n - 1); // calling merge sort on the whole array

        System.out.println("Sorted numbers:");
        for (int num : numbers) {
            System.out.print(num + " "); // printing the sorted numbers
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // if there is more than one number in this part, continue

            int middle = (left + right) / 2; // finding the middle of the array

            mergeSort(arr, left, middle); // sorting the left half
            mergeSort(arr, middle + 1, right); // sorting the right half

            merge(arr, left, middle, right); // merging the two sorted halves
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1; // size of the left part
        int n2 = right - middle; // size of the right part

        int[] leftArray = new int[n1]; // creating a temporary array for the left part
        int[] rightArray = new int[n2]; // creating a temporary array for the right part

        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i]; // copy the left part into the new array
        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[middle + 1 + j]; // copy the right part into the new array

        int i = 0, j = 0; // indexes for the left and right arrays
        int k = left; // index to write back into the original array

        while (i < n1 && j < n2) { // while there are elements in both parts
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i]; // take the smaller number from the left part
                i++;
            } else {
                arr[k] = rightArray[j]; // take the smaller number from the right part
                j++;
            }
            k++;
        }

        while (i < n1) { // if there are remaining numbers in the left part, add them
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) { // if there are remaining numbers in the right part, add them
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

// We use recursion because it is easier to divide the array into parts and then merge them into a sorted array.






