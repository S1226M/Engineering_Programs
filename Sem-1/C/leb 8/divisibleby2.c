#include<stdio.h>
void main(){
	int a,b,i;
	printf("plese ente any two numbers\n");
	scanf("%d %d",&a,&b);
	i=a;
	while(i<=b)
	{
		if(i%2==0)
		{
			printf("%d",i);
		}
		i++;
	
	}
}
