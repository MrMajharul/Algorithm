import java.util.Arrays;
import java.util.Random;

public class ArraySort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100); 
        }
        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}
