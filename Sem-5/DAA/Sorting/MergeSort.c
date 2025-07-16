#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void merge(int arr[], int l, int m, int r)
{
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[n1], R[n2];

    for (int i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[m + 1 + j];

    int i = 0, j = 0, k = l;

    while (i < n1 && j < n2)
    {
        if (L[i] <= R[j])
            arr[k++] = L[i++];
        else
            arr[k++] = R[j++];
    }

    while (i < n1)
        arr[k++] = L[i++];
    while (j < n2)
        arr[k++] = R[j++];
}

void mergeSortHelper(int arr[], int l, int r)
{
    if (l < r)
    {
        int m = l + (r - l) / 2;

        mergeSortHelper(arr, l, m);
        mergeSortHelper(arr, m + 1, r);

        merge(arr, l, m, r);
    }
}

void mergeSort(int arr[], int n)
{
    mergeSortHelper(arr, 0, n - 1);
}

int main()
{
    clock_t start, end;
    FILE *fp = NULL;
    int userChoice, n;

    printf("1. Best Case\n2. Worst Case\n3. Average Case\n");
    printf("Enter your choice: ");
    scanf("%d", &userChoice);

    switch (userChoice)
    {
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
        printf("Enter a valid number!\n");
        return 1;
    }

    if (fp == NULL)
    {
        printf("Error opening file.\n");
        return 1;
    }

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int arr[n];

    for (int i = 0; i < n; i++)
    {
        if (fscanf(fp, "%d", &arr[i]) != 1)
        {
            printf("Error reading data from file.\n");
            fclose(fp);
            return 1;
        }
    }

    fclose(fp); 

    start = clock();
    mergeSort(arr, n);
    end = clock();

    double cpuTime = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Time taken by Merge Sort: %f seconds\n", cpuTime);

    return 0;
}
