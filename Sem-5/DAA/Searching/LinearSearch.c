#include <stdio.h>
#include <time.h>
#define size 100000
int readArrayFromFile(const char *filename, int arr[], int n)
{
    FILE *f = fopen(filename, "r");
    if (!f)
    {
        printf("Cant Open file %s", filename);
        return 0;
    }
    for (int i = 0; i < n; i++)
    {
        fscanf(f, "%d", &arr[i]);
    }
    fclose(f);
    return 1;
}

void main()
{
    int arr[size];
    clock_t start, end;
    int target;
    printf("Enter the element to be searched: ");
    scanf("%d", &target);
    double time_taken;
    if (readArrayFromFile("D:/DAA/DAA/Arrays/worst_case_100000.txt", arr, size))
    {
        start = clock();
        for (int i = 0; i < size; i++)
        {
            if (arr[i] == target)
            {
                printf("Element found at index %d\n", i);
                break;
            }
        }
        end = clock();
        time_taken = ((double)(end - start) / CLOCKS_PER_SEC) * 1000;
        printf("Best time case is %lf", time_taken);
    }
}