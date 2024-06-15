#include<stdio.h>
void main(){
	float a,b,c;
	printf("plese enter 3 sides length\n");
	scanf("%f %f %f",&a,&b,&c);
	if(a==b&&b==c)
	{
		printf("this trinle is equilateral\n");
	}
	else if(a==b||b==c||c==a)
	{
		printf("this tringle is isosceles\n");
	}
	else 
	{
		printf("this tringle is scalen\n");
	}
	if(a*a==b*b+c*c||b*b==a*a+c*c||c*c==a*a+b*b)
	{
		printf("this trigle is right angle");
	}
}
