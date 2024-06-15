#include<stdio.h>
void main(){
	int a,i=1,sum=0;
	printf("plese enter a number\n");
	scanf("%d",&a);
	while(i<a)
	{
		if(a%i==0)
		{
			sum=sum+i;
		}
		i++;
	}
	if(sum==a)
	printf("this number is perfect");
	else
	printf("this number is not perfect");
}
