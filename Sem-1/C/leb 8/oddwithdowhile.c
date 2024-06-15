#include<stdio.h>
void main(){
	int a,i=1;
	printf("enter a number\n");
	scanf("%d",&a);
	do{
		if(i%2!=0)
		{
			printf("%d",i);
		}
		i++;
	}
	while(i<=a);
	
}
