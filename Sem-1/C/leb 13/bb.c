#include<stdio.h>
void main(){
	int j,i,n;
	for(i=1;i<=5;i++)
	{
		if(i%2==0)
		{
			n=0;
		}
		else
		{
			n=1;
		}
		for(j=1;j<=i;j++)
		{
			printf("%d",n);
			if(n==0)
			n=1;
			else
			n=0;
		}
		printf("\n");
	}
}
