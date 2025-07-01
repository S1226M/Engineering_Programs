// Heap Sort
#include <stdio.h>
void main(){
    FILE *fp;
    int arr[100000];
    int n = 0;

    fp = fopen("TimeComplexity.txt", "r");
    if (fp == NULL) {
        printf("Error: Cannot open file.\n");
        return;
    }

    while (fscanf(fp, "%d", &arr[n]) == 1 && n < 5) {
        n++;
    }
    fclose(fp);

    if (n == 0) {
        printf("No numbers found in file.\n");
        return;
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    for (int i = n - 1; i >= 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, i, 0);
    }

    printf("Sorted array:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}