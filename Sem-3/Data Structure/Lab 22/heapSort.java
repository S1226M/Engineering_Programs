public class heapSort {
    static void heap_sort(int arr[]){
        int n = arr.length;

        for(int i = (n / 2) - 1; i >= 0; i--){
            heapify(arr, n, i);
        }

        // One by one extract elements from the heap
        for(int i = n - 1; i > 0; i--){
            // Move the current root (maximum element) to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted at index i
    static void heapify(int arr[], int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // Left child index
        int r = 2 * i + 2; // Right child index

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than the largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If the largest is not the root
        if (largest != i) {
            // Swap the root with the largest child
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, N, largest);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 19 };
        int n = arr.length;

        System.out.println("Before using heap sort:");
        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();

        heap_sort(arr);

        System.out.println("After using heap sort:");
        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}
