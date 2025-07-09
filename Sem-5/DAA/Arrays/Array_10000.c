#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define size 10000

void write_best_case(){
    FILE *f = fopen("best_case_10000.txt","w");
    for(int i = 1;i<=size;i++){
        fprintf(f,"%d ",i);
    }
    fclose(f);
}

void write_worst_case(){
    FILE *f = fopen("worst_case_10000.txt","w");
    for(int i =size;i>=1;i--){
        fprintf(f,"%d ",i);
    }
    fclose(f);
}

void write_average_case(){
    int arr[size];
    for(int i=0;i<size;i++){
        arr[i]= i+1;
    }
    srand(time(NULL));
    for(int i=size-1;i>0;i--){
        int j=rand()%(i+1);
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    FILE *f = fopen("average_case_10000.txt","w");
    for(int i=0;i<size;i++){
        fprintf(f,"%d ",arr[i]);
    }
    fclose(f);
}

void main(){
    write_best_case();
    write_worst_case();
    write_average_case();
}