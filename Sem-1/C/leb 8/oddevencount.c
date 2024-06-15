#include<stdio.h>
void main(){
	int a,i=1,odd=0,even=0;
	while(i<=10)
	{
		printf("plese enter a number\n");
		scanf("%d",&a);
		if(a%2==0)
		{
			even++;
		}
		else
		{
			odd++;
		}
		
		i++;
	}
	printf("%d\n",odd++);
	printf("%d",even++);
	
}
