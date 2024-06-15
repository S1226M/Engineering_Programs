#include<stdio.h>
#include<math.h>
void main(){
	float a,b,c,d,r1,r2;
	printf("give the value of a,b,c\n");
	scanf ("%f %f %f",&a,&b,&c);
	d=b*b-4*a*c;
	if(d>=0)
	{
		r1=((-b)+sqrt(d))/(2*a);
		r2=((-b)-sqrt(d))/(2*a);
		printf("the root of following number is: %f %f",r1,r2);
			
	}
	else
	{
		printf("these number is imaginary");
	}
	
}  
