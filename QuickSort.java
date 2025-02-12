public class QuickSort {

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Sort left part
            quickSort(arr, pi + 1, high); // Sort right part
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; 
        int i = low - 1; 

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 6, 7, 73, 2, 256, 64, 2324};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("The sorted array is:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
