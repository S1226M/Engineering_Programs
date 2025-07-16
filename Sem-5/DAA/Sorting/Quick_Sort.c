#include <stdio.h>
#include <time.h>

void swap(int *a, int *b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

int partition(int arr[], int low, int high)
{
    int pivot = arr[high]; // Choosing last element as pivot
    int i = (low - 1);     // Index of smaller element

    for (int j = low; j <= high - 1; j++)
    {
        if (arr[j] <= pivot)
        {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

void quickSortHelper(int arr[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr, low, high);

        quickSortHelper(arr, low, pi - 1);
        quickSortHelper(arr, pi + 1, high);
    }
}

void quickSort(int arr[], int n)
{
    quickSortHelper(arr, 0, n - 1);
}

int main()
{
    clock_t start, end;
    double cpu_time_used_best, cpu_time_used_average, cpu_time_used_worst;
    FILE *fp1, *fp2, *fp3;
    int l;

    printf("Enter length of array: ");
    scanf("%d", &l);
    int arr[l], arr1[l], arr2[l];

    fp1 = fopen("best.txt", "r");
    for (int i = 0; i < l; i++)
        fscanf(fp1, "%d", &arr[i]);
    fclose(fp1);

    fp2 = fopen("average.txt", "r");
    for (int i = 0; i < l; i++)
        fscanf(fp2, "%d", &arr1[i]);
    fclose(fp2);

    fp3 = fopen("worst.txt", "r");
    for (int i = 0; i < l; i++)
        fscanf(fp3, "%d", &arr2[i]);
    fclose(fp3);

    printf("\n--- Best Case ---\n");
    start = clock();
    quickSort(arr, l);
    end = clock();
    cpu_time_used_best = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Time Complexity: %f seconds\n", cpu_time_used_best);

    printf("\n--- Average Case ---\n");
    start = clock();
    quickSort(arr1, l);
    end = clock();
    cpu_time_used_average = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Time Complexity: %f seconds\n", cpu_time_used_average);

    printf("\n--- Worst Case ---\n");
    start = clock();
    quickSort(arr2, l);
    end = clock();
    cpu_time_used_worst = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Time Complexity: %f seconds\n", cpu_time_used_worst);

    return 0;
}
