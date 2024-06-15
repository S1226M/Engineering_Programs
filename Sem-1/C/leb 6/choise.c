#include<stdio.h>
void main(){
	int a,b,c;
	float ans;
	printf("plese enter two number\n");
	scanf("%d %d",&a,&b);
	printf("here is your choise:1.add,2.sub,3.multy,4.div\n");
	printf("plese enter your choise\n");
	scanf(" %d",&c);
	if(c==1)
	{
		ans=a+b;
		printf(" your ans is %f",ans);
	}
	else if(c==2)
	{
		ans=a-b;
		printf(" your ans is %f",ans);
	}
	else if(c==3)
	{
		ans=a*b;
		printf(" your ans is %f",ans);
	}
	else if(c==4)
	{
		if(b<0)
		{
			printf("plese enter positive number");
		}
		else
	    {
			ans=a/b;
			printf(" your ans is %f",ans);
		}
	}
	else
	{
		printf("plese enter any two number");
	}
	
}
