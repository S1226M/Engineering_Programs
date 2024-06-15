#include<stdio.h>
void main(){
	int j,i,n=5;
	char b;
	for(i=1;i<=5;i++)
	{
		for(j=1;j<=n-i;j++)
		{
			printf(" ");
		}
		for(j=1;j<=2*i-1;j++)
		{
			if(j==1||j==2*i-1)
			printf("*");
			else
			printf(" ");
		}
		printf("\n");
	}
		for(i=4;i>=1;i--)
	{
		for(j=1;j<=n-i;j++)
		{
			printf(" ");
		}
		for(j=1;j<=2*i-1;j++)
		{
			if(j==1||j==2*i-1)
			printf("*");
			else
			printf(" ");	
		}
		printf("\n");
	}
}
