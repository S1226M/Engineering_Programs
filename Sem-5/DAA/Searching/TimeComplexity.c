#include <stdio.h>
#include <time.h>

void main(){
    FILE *fp;
    clock_t start , end;
    double cpu_time_used;
    int arr[100000];
    int n = 100000;
    start = clock();
    fp = fopen("TimeComplexity.txt","w");
    for(int i = 0; i < 100000; i++){
        fprintf(fp,"%d ",i);
    }
    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("\n\nTime taken: %f seconds\n",cpu_time_used);
    fprintf(fp,"Time taken: %f seconds\n",cpu_time_used);
    fclose(fp);
}

