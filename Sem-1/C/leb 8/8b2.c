#include<stdio.h>
void main(){
	int a=100;
	while(a>=100&&a<=200)
	{
		if(a%7==0&&a%5!=0)
		printf("%d\n",a);
		a++;
	}
	
}
