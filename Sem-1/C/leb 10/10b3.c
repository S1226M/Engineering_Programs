#include<stdio.h>
void main(){
	int a,b,rev=0;
	printf("plese enter a number:-\n");
	scanf("%d",&a);
	b=a;
	while(a!=0)
	{
		rev=(rev*10)+(a%10);
		a=a/10;
	}	
	if(rev==b)
	{
		printf("this number is palindrome");
	}
	else
	{
		printf("this number is not palindrome");
	}
}
