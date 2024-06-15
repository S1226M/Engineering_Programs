#include<stdio.h>
void main(){
	int c;
	float a,b,ans;
	printf("plese enter two number\n");
	scanf("%f %f",&a,&b);
	printf("plese enter your choise\n");
	scanf("%d",&c);
	switch(c)
	{
	    case 1:
		    ans=a+b;
		    printf(" your ans is %f",ans);
	        break;
	    case 2:
		    ans=a-b;
		    printf(" your ans is %f",ans);
 		    break;
	    case 3:
		    ans=a*b;
		    printf(" your ans is %f",ans);
	        break;
	    case 4:
	    	if(b==0)
		{
			printf("plese enter non zero number");
		}
		else
	    {
			ans=a/b;
			printf(" your ans is %f",ans);
		}
		    break;
		default:
			printf("plese enter a velid choise");
			break;
	}
}
