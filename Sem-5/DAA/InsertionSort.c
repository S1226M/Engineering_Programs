#include <stdio.h>
#include <time.h>
#define SIZE 10

void InsertionSort(int arr[]){
	int Key ,i , j;
	for(i = 1 ; i < SIZE ; i++){
		Key = arr[i];
		j = i-1;
		while( j>=0 && arr[j] > Key){
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = Key;
	}
}

int main(){
	int arr[SIZE] , i;
	for (i = 0; i < SIZE; i++) {
        printf("Enter Number %d: ", i + 1);
        scanf("%d", &arr[i]);
    }
	
	clock_t start = clock();
	InsertionSort(arr);
	clock_t end = clock();
	
	for(i = 0 ; i < SIZE ; i++){
		printf("%d ", arr[i]);
	}
	
	double time = (double)(end - start) / CLOCKS_PER_SEC;
	printf("time : %f",time);
}
