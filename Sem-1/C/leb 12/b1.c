#include<stdio.h>
void main(){
	int a,i,j,sum=0;
	printf("plese enter a number\n");
	scanf("%d",&a);
	for(i=1;i<=a;i++)
	{
		for(j=1;j<=i;j++)
		{
			sum=sum+j;
		}
	}
	printf("%d",sum);
}
