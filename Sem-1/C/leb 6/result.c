#include<stdio.h>
void main (){
	int m1,m2,m3,m4,m5;
	float per;
	printf("plese enter marks of five subject\n");
	scanf("%d %d %d %d %d",&m1,&m2,&m3,&m4,&m5);
	per=(m1+m2+m3+m4+m5)/5.0;
	if(per<35)
	{
		printf("you are fail");
	}
	else if(per>=35 && per<45)
	{
		printf("you  are pass");
	}
	else if(per>=45 && per<60)
	{
		printf("you  are in second class");
	}else if(per>=60 && per<70)
	{
		printf("you  are in first class");
	}
	else if(per>=70)
	{
		printf("you  are in Distinction");
	}
}
