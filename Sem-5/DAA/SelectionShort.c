#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 10000
int main()
{
    FILE *fp;
    int arr[MAX];
    int n = 0;

    fp = fopen("TimeComplexity.txt", "r");
    if (fp == NULL)
    {
        printf("Error: Cannot open file.\n");
        return 1;
    }

    while (fscanf(fp, "%d", &arr[n]) == 1 && n < MAX)
    {
        n++;
    }
    fclose(fp);

    if (n == 0)
    {
        printf("No numbers found in file.\n");
        return 1;
    }

    clock_t start = clock();

    for (int i = 0; i < n - 1; i++)
    {
        int min = i;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] < arr[min])
            {
                min = j;
            }
        }
        if (min != i)
        {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    clock_t end = clock();
    double time_taken = ((double)(end - start)) / CLOCKS_PER_SEC;

    printf("Sorted array:\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");

    printf("Time taken to sort: %f seconds\n", time_taken);

    fp = fopen("TimeComplexity.txt", "a");
    if (fp != NULL)
    {
        fprintf(fp, "\nTime taken to sort: %f seconds\n", time_taken);
        fclose(fp);
    }
    else
    {
        printf("Error: Could not open file to append time.\n");
    }

    return 0;
}
