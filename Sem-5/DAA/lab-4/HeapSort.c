#include <stdio.h>
#include<time.h>
#define size 100000
int readArrayFromFile(const char *filename,int arr[],int n){
    FILE *f = fopen(filename,"r");
    if(!f){
        printf("Cant Open file %s",filename);
        return 0;
    }
    for(int i=0;i<n;i++){
        fscanf(f,"%d",&arr[i]);
    }
    fclose(f);
    return 1;
}

void heapify(int arr[],int n, int i){
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if( left < n && arr[left]> arr[largest] ){
        largest = left;
    }
    if( right < n && arr[right]> arr[largest] ){
        largest = right;
    }
    if(largest != i){
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr, n, largest);
    }
}

void heapSort(int arr[], int n){
    for(int i = n / 2 - 1; i >= 0; i--){
        heapify(arr, n, i);
    }
    for(int i = n - 1; i > 0; i--){
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, i, 0);
    }
}

int main(){
    int arr[size];
    clock_t start,end;
    double time_taken;
    if(readArrayFromFile("D:/DAA/DAA/Arrays/average_case_100000.txt",arr,size)){
    start = clock();
    heapSort(arr,size);
    end=clock();
    // for(int i =0;i<size;i++){
    //     printf("%d ",arr[i]);
    // }
    time_taken=((double)(end-start)/CLOCKS_PER_SEC);
    printf("worst time case is %lf",time_taken);
    }
    
}