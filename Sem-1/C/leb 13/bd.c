#include<stdio.h>
void main(){
	int j,i,n=5,a;
	char b;
	for(i=1;i<=5;i++)
	{
		a=1;
		b='A';
		for(j=1;j<=n-i;j++)
		{
			printf(" ");
		}
		for(j=1;j<=2*i-1;j++)
		{
			if(j%2==1)
			{
				if(i%2==1)
				printf("%d",a++);
				else
				printf("%c",b++);
			}
			else
			printf(" ");
		}
		printf("\n");
	}
}
