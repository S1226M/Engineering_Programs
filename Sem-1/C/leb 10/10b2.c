#include<stdio.h>
void main(){
	int a,i=1,flag=0;
	printf("plese enter a number\n");
	scanf("%d",&a);
	while(i<=a)
	{
		if(a%i==0)
		{
			flag=flag+1;
		}
		i++;
	}
	if(flag==2)
	printf("this number is prime");
	else
	printf("not prime");
}
