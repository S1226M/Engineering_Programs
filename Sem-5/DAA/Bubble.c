#include <stdio.h>
#include <time.h>
#define SIZE 10

void BubbleSort(int arr[]){
	int temp,i,j;
	for(i=0 ; i < SIZE - 1 ; i++){
		for(j=0 ; j < SIZE - i - 1 ; j++){
			if(arr[j] > arr[j+1]){
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
}

int main(){
	int arr[SIZE] , i;
	printf("Enter %d Number : ", SIZE);
	for(i=0 ; i < SIZE ; i++) scanf("%d",&arr[i]);
	
	clock_t start = clock();
	BubbleSort(arr);
	clock_t end = clock();
	
	for(i=0 ; i<SIZE ; i++){
		printf("%d ",arr[i]);
	}
	
	double time_taken = (double)(end - start) / CLOCKS_PER_SEC;
	printf("\nTime : %f seconds\n", time_taken);

}
