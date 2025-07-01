#include<stdio.h>
#include<time.h>
void InsertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
void main(){
    int arr[] = {10,8,1,50,80,40};
    int n = sizeof(arr)/sizeof(arr[0]);
    InsertionSort(arr, n);
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
}