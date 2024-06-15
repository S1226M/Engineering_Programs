#include<stdio.h>
int factorial(int);
int ncr(int,int);
int main(){
	int i,j,n;
	printf("plese enter a number\n");
	scanf("%d",&n);
	for(i=0;i<=n;i++)
	{
		for(j=1;j<=n-i;j++)
		{
			printf(" ");
		}
		for(j=0;j<=i;j++)
		{
			int b=combi(i,j);
			printf("%d ",b);
		}
		printf("\n");
	}
	return 0;
}
int factorial(int x)
{
	int fac=1,i;	
	for(i=2;i<=x;i++){
		fac=fac*i;
	}
	return fac;		
}
int combi(int n,int r){
	int ncr;
	ncr=factorial(n)/(factorial(r)*factorial(n-r));
	return ncr;
}
