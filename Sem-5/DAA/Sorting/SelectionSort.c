#include<stdio.h>
#include<time.h>

void selectionSort(int arr[], int len){
    for(int i=0; i<len-1; i++){
        int smallest = i;
        for(int j=i+1; j<len; j++){
            if(arr[smallest] > arr[j]){
                smallest = j;
            }
        }

        int temp = arr[smallest];
        arr[smallest] = arr[i];
        arr[i] = temp;
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
            printf("Enter valid number!!!\n");
            return;
    }

    printf("Enter number of element : ");
    scanf("%d", &n);

    for(int i=0; i<n; i++){
        fscanf(fp, "%d", &arr[i]);
    }

    start = clock();
    selectionSort(arr, n);
    end = clock();
    printArray(arr, n);

    double cpuTime = (double) ((end-start))/CLOCKS_PER_SEC;

    printf("Time taken by selection sort : %f", cpuTime);
}