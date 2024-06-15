#include<stdio.h>
void main(){
	int a,i=1,b,c,sum;
	printf("plese enter a number\n");
	scanf("%d",&a);
	b=a%10;
	while(a>=10)
	{
		a=a/10;
	}
	c=a;
	sum=b+c;
	printf("%d",sum);
}
