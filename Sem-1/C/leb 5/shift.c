#include<stdio.h>
void main(){
	int x;
	float y;
	printf("plese enter a number\n");
	scanf("%d",&x);
	x=x<<1;
	y=x>>1;
	printf("the number is: %d\n",x);
	printf("the number is: %f",y);
}
