#include<stdio.h>
void main(){
	int a,count;
	printf("plese enter a number:-\n");
	scanf("%d",&a);
	for(count=0;a!=0;count++)
	{
		a=a/10;
	}
	printf("the frequency of given number is:-%d",count);
}
