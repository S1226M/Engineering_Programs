#include<stdio.h>
void main(){
	float i,j,sum=1,k,l,a;
	printf("plese enter a number\n");
	scanf("%f",&a);
	for(i=0;i<=a;i++)
	{
		l=1;
		for(k=i+1;k>0;k--)
			{
				l=l*k;
			}
			sum=sum+(1/l);
	}
	printf("%f",sum);
}
