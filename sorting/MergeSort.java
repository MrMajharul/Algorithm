package sorting;
class MergeSort {
    void merge(int arr[], int left, int mid, int right) {
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                i++;
            } else {
                int temp = arr[j];
                int k = j;

                // Shift right
                while (k > i) {
                    arr[k] = arr[k - 1];
                    k--;
                }
                arr[i] = temp;

                i++;
                mid++;
                j++;
            }
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
        int arr[] = {12, 11, 13, 17, 48, 99, 424, 101, 482, 223, 56, 67, 17};
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
