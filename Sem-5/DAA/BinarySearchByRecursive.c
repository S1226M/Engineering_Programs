// Binary Search in c by recursive function
#include <stdio.h>
int binarySearch(int arr[], int left, int right, int key) {
    if (right >= left) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == key){
            return mid;
        }
        if (arr[mid] > key){
            return binarySearch(arr, left, mid - 1, key);
        }
        return binarySearch(arr, mid + 1, right, key);
    }
    return -1;
}
void main() {
    int arr[] = {2, 3, 5, 6, 8};
    int n = sizeof(arr) / sizeof(arr[0]);
    int key = 6;
    int result = binarySearch(arr, 0, n - 1, key);

    if (result != -1) {
        printf("Element %d found at index %d\n", key, result);
    } else {
        printf("Element %d not found in the array\n", key);
    }
}