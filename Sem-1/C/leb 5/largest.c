#include<stdio.h>
void main(){
	int a,b,c;
	printf("please enter three number\n");
	scanf("%d %d %d",&a,&b,&c);
	if(a>b)
	{
		if(a>c)
		{
			printf("the largest is %d",a);
		}
		else
		{
			printf("the largest is %d",c);
		}
	}
	else
	{
		if(b>c)
			{
				printf("the largest is %d",b);
			}
			else
			{
				printf("the largest is %d",c);
			}
	}

}
