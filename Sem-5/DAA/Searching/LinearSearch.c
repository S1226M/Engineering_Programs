#include <stdio.h>
#include <time.h>

int linearSearch(int arr[], int n, int x) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == x)
            return i;
    }
    return -1;
}

void printArray(int arr[], int len){
    for(int i = 0; i < len; i++){
        printf("%d\t", arr[i]);
    }
    printf("\n");
}

void main() {
    FILE *fp;
    clock_t start, end;
    int arr[100000];
    int n, userChoice, x;

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

    printf("Enter element to search: ");
    scanf("%d", &x);

    start = clock();
    int result = linearSearch(arr, n, x);
    end = clock();

    printArray(arr, n);

    if (result != -1) {
        printf("Element found at index %d\n", result);
    } else {
        printf("Element not found in the array\n");
    }

    double cpuTime = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Time taken by Linear Search: %f seconds\n", cpuTime);
}
