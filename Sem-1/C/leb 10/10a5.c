#include<stdio.h>
void main(){
	int a,rev=0;
	printf("plese enter a number:-\n");
	scanf("%d",&a);
	while(a!=0)
	{
		rev=(rev*10)+(a%10);
		a=a/10;
	}
	printf("%d",rev);
}
