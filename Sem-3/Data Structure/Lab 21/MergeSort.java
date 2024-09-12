public class MergeSort {
    public static void merge(int a[], int low, int mid, int high) {
        int i = 0, j = 0, h = 0, k = 0;
        int b[] = new int[high - low + 1];
        h = low;
        i = 0;
        j = mid + 1;
        while (h <= mid && j <= high) {
            if (a[h] <= a[j]) {
                b[i] = a[h];
                h++;
            } else {
                b[i] = a[j];
                j++;
            }
            i++;
        }
        while (h <= mid) {
            b[i] = a[h];
            h++;
            i++;
        }
        while (j <= high) {
            b[i] = a[j];
            j++;
            i++;
        }
        for (k = low; k <= high; k++) {
            a[k] = b[k - low];
        }
    }

    public static void merge_sort(int[] a, int low, int high) {
        int mid = 0;
        if (low >= high) return;
            mid = (low + high) / 2;
            merge_sort(a, low, mid);
            merge_sort(a, mid + 1, high);
            merge(a, low, mid, high);
    }

    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        int n = arr.length;
        System.out.println("Before Using merge Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        merge_sort(arr, 0, arr.length-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}