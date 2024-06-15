#include<stdio.h>
void main(){
	int a,count=0;
	printf("plese enter a number:-\n");
	scanf("%d",&a);
	while(a!=0)
	{
		a=a/10;
		count++;
	}
	printf("the digit of given number is:-%d",count);
}
