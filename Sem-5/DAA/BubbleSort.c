#include<stdio.h>
void BubbleSort(int arr[] , int n){
    for(int i=0 ; i<n-1 ; i++){
        for(int j=0 ; j < (n - i - 1); j++){
            if(arr[j] > arr[j+1]){
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            } 
        }
    }
}
void main(){
    int arr[] = {10,8,1,50,80,40};
    int n = sizeof(arr)/sizeof(arr[0]);
    BubbleSort(arr,n);
    for (int  i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}