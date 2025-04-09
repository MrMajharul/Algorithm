import java.util.Arrays;
import java.util.Random;

public class MergeAndSortArray {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rand.nextInt(100); 
        }
        int[] arr2 = new int[10];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = rand.nextInt(100);
        }
        int[] combined = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, combined, 0, arr1.length);
        System.arraycopy(arr2, 0, combined, arr1.length, arr2.length);

        System.out.println("First array:  " + Arrays.toString(arr1));
       
       
        System.out.println("Second array: " + Arrays.toString(arr2));
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr2));
        System.out.println("Combined array: " + Arrays.toString(combined));

        Arrays.sort(combined);
        System.out.println("Sorted combined array: " + Arrays.toString(combined));
    }
}
