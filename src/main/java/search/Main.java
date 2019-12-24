package search;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 8, -52, -9, 0, 0, 0, 3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int i = binarySearch(arr, -9);
        System.out.println(i);
    }

    public static int binarySearch(int[] arr, int element) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int pivot = (left + right) / 2;

            if (element < arr[pivot]) {
                right = pivot - 1;
            } else if (element > arr[pivot]) {
                left = pivot + 1;
            } else return pivot;
        }
        return -1;
    }
}
