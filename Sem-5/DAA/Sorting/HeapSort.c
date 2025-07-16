#include <stdio.h>
#include <time.h>

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

void heapSort(int arr[], int n) {
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    for (int i = n - 1; i >= 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        heapify(arr, i, 0);
    }
}

void printArray(int arr[], int len){
    for(int i = 0; i < len; i++){
        printf("%d\t", arr[i]);
    }
    printf("\n");
}

void main(){
    FILE *fp;
    clock_t start, end;
    int n, userChoice;
    int arr[100000];

    printf("1.best case\n2.worst case\n3.average case\n");
    scanf("%d", &userChoice);

    switch (userChoice) {
        case 1:
            fp = fopen("best.txt", "r");
            break;
        case 2:
            fp = fopen("worst.txt", "r");
            break;
        case 3:
            fp = fopen("average.txt", "r");
            break;
        default:
            printf("Enter valid number!!!\n");
            return;
    }
    
    printf("Enter number of elements: ");
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        fscanf(fp, "%d", &arr[i]);
    }

    fclose(fp);

    start = clock();
    heapSort(arr, n);
    end = clock();

    double cpuTime = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Time taken by Heap Sort: %f seconds\n", cpuTime);
}
