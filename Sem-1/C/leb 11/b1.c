#include<stdio.h>
void main(){
	int a=0,b=1,i,n,c;
	printf("plese enter a number\n");
	scanf("%d",&n);
	printf("0 1 ");
	for(i=3;i<=n;i++)
	{
		c=a+b;
		printf("%d ",c);
		a=b;
		b=c;
	}
}
