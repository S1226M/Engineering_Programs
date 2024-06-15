#include<stdio.h>
void main(){
	char upper='A',lower='a',number='0';
	int i;
	for(i=48;i<=57;i++)
	{
		printf("%c=%d\n",number++,i);
	}
	for(i=65;i<=90;i++)
	{
		printf("%c=%d\n",upper++,i);
	}for(i=97;i<=122;i++)
	{
		printf("%c=%d\n",lower++,i);
	}
}
