public class QuickSort {
    static int i = 0;
    static int j = 0;
    static int key = 0;

    public static void quick_sort(int k[], int lb, int ub) {
        boolean flag = true;
        if (lb < ub) {
            i = lb;
            j = ub + 1;
            key = k[lb];
            while (flag) {
                i++;
                while (k[i] < key) {
                    i++;
                }
                j--;
                while (k[j] > key) {
                    j--;
                }
                if (i < j) {
                    int temp = k[i];
                    k[i] = k[j];
                    k[j] = temp;
                } else {
                    flag = false;
                }
            }
            int temp = k[lb];
            k[lb] = k[j];
            k[j] = temp;
            quick_sort(k, lb, j - 1);
            quick_sort(k, j + 1, ub);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 42, 23, 74, 11, 65, 58, 94, 36, 99, 87 };
        int n = arr.length;
        System.out.println("Before Using quick Sort: ");
        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
        quick_sort(arr, 0, arr.length - 1);
        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}