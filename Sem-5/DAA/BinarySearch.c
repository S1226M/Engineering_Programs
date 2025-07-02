// Binary Search in C
#include <stdio.h>
void main(){
    int arr[] = {2, 3, 5, 6, 8};
    int n = sizeof(arr) / sizeof(arr[0]);
    int key = 6;
    int left = 0, right = n - 1;
    int found = 0;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == key) {
            printf("Element %d found at index %d\n", key, mid);
            found = 1;
            break;
        } else if (arr[mid] < key) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    if (!found) {
        printf("Element %d not found in the array\n", key);
    }
}