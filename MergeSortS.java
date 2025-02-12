import java.util.Scanner;

public class MergeSortS {
    void merge(int arr[], int left, int mid, int right) {
        int l = mid - left + 1;
        int r = right - mid;
        int leftArray[] = new int[l];
        int rightArray[] = new int[r];

        for (int i = 0; i < l; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < r; ++j) {
            rightArray[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        while (i < l && j < r) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < l) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < r) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking array size input
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];

        // Taking array elements input
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sorting the array using Merge Sort
        MergeSortS ob = new MergeSortS();
        ob.sort(arr, 0, arr.length - 1);

        // Printing the sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
