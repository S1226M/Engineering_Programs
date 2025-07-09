#include <stdio.h>
#include <time.h>
#define size 100000
int readArrayFromFile(const char *filename, int arr[], int n)
{
    FILE *f = fopen(filename, "r");
    if (!f)
    {
        printf("Cant Open file %s", filename);
        return 0;
    }
    for (int i = 0; i < n; i++)
    {
        fscanf(f, "%d", &arr[i]);
    }
    fclose(f);
    return 1;
}


int BinarySearch(int arr[],int st,int end,int target){
    if(st>=end){
        return -1;
    }
    int mid = st + (end-st)/2;
    if(arr[mid]==target){
        return mid;
    }else if(arr[mid]<target){
        BinarySearch(arr,mid+1,end,target);
    }else{
        BinarySearch(arr,st,mid-1,target);
    }
}

void main(){
    int arr[size];
    clock_t start, end;
    int target;
    printf("Enter the element to be searched: ");
    scanf("%d", &target);
    double time_taken;
    if (readArrayFromFile("D:/DAA/DAA/Arrays/best_case_100000.txt", arr, size))
    {
        start = clock();
        int st=0;end=size-1;
        int ans = BinarySearch(arr, st, end, target);
        end = clock();
        if(ans!=-1){
        printf("Target Found at index %d \n",ans);
        }else{
            printf("Target Not Found");
        }
        time_taken = ((double)(end - start) / CLOCKS_PER_SEC);
        printf("Best time case is %lf", time_taken);
    }
}
