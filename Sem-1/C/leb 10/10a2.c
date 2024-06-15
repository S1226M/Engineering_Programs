#include<stdio.h>
void main(){
	int a,i=1,b,sum=0;
	printf("plese enter a number that want you calculate:\n");
	scanf("%d",&a);
	while(i<=a)
	{
		printf("plese enter number\n");
		scanf("%d",&b);
		sum=sum+b;
		i++;	
	}
	printf("%d\n",sum);
	printf("%d",sum/a);
}
