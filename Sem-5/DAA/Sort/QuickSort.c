#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define size 100000

int readArrayFromFile(const char *filename, int arr[], int n)
{
    FILE *f = fopen(filename, "r");
    if (!f)
    {
        printf("Cannot open file: %s\n", filename);
        return 0;
    }

    for (int i = 0; i < n; i++)
    {
        if (fscanf(f, "%d", &arr[i]) != 1)
        {
            printf("Error reading data at index %d\n", i);
            fclose(f);
            return 0;
        }
    }

    fclose(f);
    return 1;
}

// Step 2: Swap helper
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Step 3: Partition function
int partition(int arr[], int low, int high)
{
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }

    swap(&arr[i + 1], &arr[high]);
    return i + 1;
}

// Step 4: QuickSort recursive
void quickSort(int arr[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

// Step 5: Main with time measurement
int main()
{
    int arr[size];

    // Use separate variable names to avoid conflict
    clock_t start_time, end_time;
    double time_taken;

    const char *filename = "D:/DAA/DAA/Arrays/average_case_100000.txt";

    if (!readArrayFromFile(filename, arr, size))
    {
        printf("Failed to read array from file.\n");
        return 1;
    }

    printf("File read successfully. Starting QuickSort...\n");

    start_time = clock();
    quickSort(arr, 0, size - 1);
    end_time = clock();

    time_taken = ((double)(end_time - start_time)) / CLOCKS_PER_SEC;

    printf("QuickSort completed.\n");
    printf("Time taken to sort %d elements: %.6lf seconds\n", size, time_taken);

    return 0;
}