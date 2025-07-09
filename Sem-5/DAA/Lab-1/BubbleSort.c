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

void bubble_sort(int arr[],int n){
    int swapped;
    for(int i =0;i<n;i++){
        swapped=0;
        for(int j=0;j<n-i-1;j++){
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                swapped=1;
            }
        }
        if(swapped==0){
            break;
        }
    }
}

int main(){
    int arr[size];
    clock_t start,end;
    double time_taken;
    if(readArrayFromFile("D:/DAA/DAA/Arrays/worst_case_1000.txt",arr,size)){
    start = clock();
    bubble_sort(arr,size);
    end=clock();
    // for(int i =0;i<size;i++){
    //     printf("%d ",arr[i]);
    // }
    time_taken=((double)(end-start)/CLOCKS_PER_SEC);
    printf("Best time case is %lf",time_taken);
    }
    
}