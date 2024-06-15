#include<stdio.h>
void main(){
	int j,i,n=5,b=1,c;
	for(i=5;i>=1;i--)
	{
		for(j=5;j>n-i;j--)
		{
			printf("%d",b);
			b++;
			c=b;
		}
		b=b-c+1;
		printf("\n");
	}
}
