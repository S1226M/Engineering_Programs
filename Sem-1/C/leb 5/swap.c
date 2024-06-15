#include<stdio.h>
void main(){
	int a,b,c;
	printf("plese enter your first number\n");
	scanf("%d",&a);
	printf("plese enter your second number\n");
	scanf("%d",&b);
	c=a;
	a=b;
	b=c;
	printf("swape numbers are: %d %d",a,b);
	
}
