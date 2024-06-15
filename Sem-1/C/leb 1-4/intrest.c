#include<stdio.h>
void main(){
	float p,r,t,intrest;
	printf("plese enter p\n");
	scanf("%f",&p);
	printf("plese enter r\n");
	scanf("%f",&r);
	printf("plese enter t\n");
	scanf("%f",&t);
	intrest=(p*r*t)/100;
	printf("your intrest is:\n %f",intrest);
}
