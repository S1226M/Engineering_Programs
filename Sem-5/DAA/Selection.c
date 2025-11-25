#include<stdio.h>
#include<time.h>
#define SIZE 10

void Selection(int arr[]){
	int i , j , temp;
	int min = 0;
	for(i=0 ; i < SIZE ; i++){
		for(j=i+1 ; j<SIZE ; j++){
			if(arr[j] < arr[min]){
				min = j;
			}
		}	
		temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
	}
}

int main(){
	int arr[SIZE] , i;
	for (i = 0; i < SIZE; i++) {
        printf("Enter Number %d: ", i + 1);
        scanf("%d", &arr[i]);
    }
	
	clock_t start = clock();
	Selection(arr);
	clock_t end = clock();
	
	for(i = 0 ; i < SIZE ; i++){
		printf("%d ", arr[i]);
	}
	
	double time = (double)(end - start) / CLOCKS_PER_SEC;
	printf("time Selection : %f",time);
}
