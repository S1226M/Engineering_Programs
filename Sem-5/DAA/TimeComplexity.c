#include <stdio.h>
#include <time.h>
void main()
{
    FILE *fp, *fp1, *fp2;
    clock_t start, end;
    double cpu_time_used;
    int arr[100000];
    int n = 100000;
    start = clock();
    fp = fopen("TimeComplexity.txt", "w");
    for (int i = 0; i < 100000; i++)
    {
        fprintf(fp, "%d ", i);
        fprintf(fp1, "%d ", n - i + 1);
        fprintf(fp2, "%d ", rand());
    }
    end = clock();
    cpu_time_used = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("\nTime taken: %f seconds\n", cpu_time_used);
    fprintf(fp, "Time taken: %f seconds\n", cpu_time_used);
    fclose(fp);

    
    start = clock();
    fp = fopen("TimeComplexity.txt", "r");
    for (int i = 0; i < n; i++)
    {
        fscanf(fp, "%d", &arr[i]);
    }
    end = clock();
    cpu_time_used = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("\nBest Case Time taken to read data: %f seconds\n", cpu_time_used);
    fprintf(fp, "Best Case Time taken to read data: %f seconds\n", cpu_time_used);
    fclose(fp);

    // Worst Case to read data
    start = clock();
    fp = fopen("TimeComplexity.txt", "r");
    for (int i = 0; i < n; i++)
    {
        fscanf(fp, "%d", &arr[i]);
    }
    end = clock();
    cpu_time_used = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("\nWorst Case Time taken to read data: %f seconds\n", cpu_time_used);
    fprintf(fp, "Worst Case Time taken to read data: %f seconds\n", cpu_time_used);
    fclose(fp);

    // Average Case to read data
    start = clock();
    fp = fopen("TimeComplexity.txt", "r");
    for (int i = 0; i < n; i++)
    {
        fscanf(fp, "%d", &arr[i]);
    }
    end = clock();
    cpu_time_used = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("\nAverage Case Time taken to read data: %f seconds\n", cpu_time_used);
    fprintf(fp, "Average Case Time taken to read data: %f seconds\n", cpu_time_used);
    fclose(fp);
}