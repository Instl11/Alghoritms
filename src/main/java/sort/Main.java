package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 8, -52, -9};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minInd = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minInd] > arr[j]) {
                    minInd = j;
                }
            }
            int temp = arr[minInd];
            arr[minInd] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        quickSortWithBounds(arr, left, right);
    }

    private static void quickSortWithBounds(int[] arr, int left, int right) {
        if (left < right) {
            int separator = separate(arr, left, right);
            quickSortWithBounds(arr, left, separator);
            quickSortWithBounds(arr, separator + 1, right);
        }
    }

    private static int separate(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        left = left - 1;
        right = right + 1;

        while (true) {
            while (arr[++left] < pivot) ;
            while (arr[--right] > pivot) ;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else {
                return right;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        int l = arr.length;
        mergeSorting(arr, l);
    }

    private static void mergeSorting(int[] arr, int length) {

        if (length < 2) {
            return;
        }

        int mid = length / 2;
        int[] l = new int[mid];
        int[] r = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < length; i++) {
            r[i - mid] = arr[i];
        }

        mergeSorting(l, mid);
        mergeSorting(r, length - mid);

        merge(arr, l, mid, r, length - mid);
    }

    private static void merge(int[] arr, int[] l, int lLength, int[] r, int rLength) {

        int i = 0, j = 0, k = 0;
        while (i < lLength && j < rLength) {

            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }

        while (i < lLength) {
            arr[k++] = l[i++];
        }
        while (j < rLength) {
            arr[k++] = r[j++];
        }
    }


}