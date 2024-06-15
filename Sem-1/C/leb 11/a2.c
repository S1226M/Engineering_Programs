#include<stdio.h>
void main(){
	int a,i,sum=0;
	printf("plese enter a number\n");
	scanf("%d",&a);
	for(i=1;i<=a;i++)
	{
		sum=sum+i;
	}
	printf("%d",sum);
}
