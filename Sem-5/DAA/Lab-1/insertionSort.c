#include<stdio.h>
#include<time.h>
#define size 1000
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
int insertionSort(int arr[], int n){
    int i,j,key;
    for ( i = 1; i < n; i++)
    {
        key = arr[i];
        j = i - 1;
        while (j >= 0 && key < arr[j])
        {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
    return 0;
}

int main(){
    int arr[size];
    clock_t start,end;
    double time_taken;
    if(readArrayFromFile("D:/DAA/DAA/Arrays/average_case_1000.txt",arr,size)){
    start = clock();
    insertionSort(arr,size);
    end=clock();
    // for(int i =0;i<size;i++){
    //     printf("%d ",arr[i]);
    // }
    time_taken=((double)(end-start)/CLOCKS_PER_SEC);
    printf("worst time case is %lf",time_taken);
    }
    
}