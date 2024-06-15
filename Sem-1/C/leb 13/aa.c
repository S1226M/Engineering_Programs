#include<stdio.h>
void main(){
	int j,i,n=5;
	for(i=5;i>=1;i--)
	{
		for(j=5;j>n-i;j--)
		{
			printf("*");
		}
		printf("\n");
	}
}
