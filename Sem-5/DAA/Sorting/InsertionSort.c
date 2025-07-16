#include<stdio.h>
#include<time.h>

void insertionSort(int arr[], int len){
    for(int i=1; i<len; i++){
        int current = arr[i];
        int j = i-1;
        
        while(j >= 0 && current < arr[j]){
            arr[j+1] = arr[j];
            j--;
        }

        arr[j+1] = current;
    }
}

void printArray(int arr[], int len){
    for(int i=0; i<len; i++){
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
        printf("Enter valid number!!!");
        break;
    }

    printf("Enter number of element : ");
    scanf("%d", &n);

    for(int i=0; i<n; i++){
        fscanf(fp, "%d", &arr[i]);
    }

    start = clock();
    insertionSort(arr, n);
    end = clock();

    double cpuTime = (double) ((end-start))/CLOCKS_PER_SEC;

    printf("Time taken by insertion sort : %f", cpuTime);
}