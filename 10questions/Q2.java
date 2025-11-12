import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = {2, 4, 6, 8, 10, 12, 14, 16};

        System.out.print("Enter the number to search: ");
        int target = sc.nextInt(); // reading the number we want to find

        int left = 0; // start index of the search range
        int right = numbers.length - 1; // end index of the search range
        int index = -1; // variable to store the found index, -1 means not found

        // binary search loop
        while (left <= right) {
            int mid = (left + right) / 2; // find the middle index

            if (numbers[mid] == target) { // if the middle element is the target
                index = mid; // save the index
                break; // exit the loop, we found the number
            } else if (numbers[mid] < target) { // if target is bigger than middle
                left = mid + 1; // ignore the left half
            } else { // if target is smaller than middle
                right = mid - 1; // ignore the right half
            }
        }

        if (index == -1) {
            System.out.println("Number not found"); // number is not in the array
        } else {
            System.out.println("Number found in index: " + index); // print the index of the number
        }
    }
}

// Binary search is more efficient than linear search because:
// 1) Linear search checks every number one by one, which can take a long time if the list is big.
// 2) Binary search looks at the middle number and decides which half to check next, so it finds the number faster without checking everything.
// 3) This method works only if the numbers are already sorted.

