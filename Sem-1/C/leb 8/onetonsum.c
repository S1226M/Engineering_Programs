#include<stdio.h>
void main(){
	int n,sum=0,i=1;
	printf("plese enter a number\n");
	scanf("%d",&n);
	while(i<=n)
	{
		sum=sum+i;
		i++;
	}
	printf("%d",sum);
}
