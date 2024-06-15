#include<stdio.h>
void main(){
	int a,b;
	printf("enter a number\n");
	scanf("%d",&a);
	b=a%10;
	if(b&1==1)
	{
		printf("the number is odd");
	}
	else
	{
		printf("the number is even");
	}
}
