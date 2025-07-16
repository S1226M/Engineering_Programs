#include<stdio.h>
#include<time.h>

void bubbleSort(int arr[], int len){
    for(int i=0; i<len-1; i++){
        for(int j=0; j<len-i-1; j++){
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
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
    bubbleSort(arr, n);
    end = clock();

    double cpuTime = (double) ((end-start))/CLOCKS_PER_SEC;

    printf("Time taken by bubble sort : %f", cpuTime);
}