#include<stdio.h>
void main(){
	char c;
	printf("plese enter a character\n");
	scanf("%c",&c);
	if(c>='A' && c<='Z')
	{
		printf("tihis is upper");
	}
	else if(c>='a' && c<='z')
	{
		printf("this is lower");
	}
	else if(c>=48 && c<=57)
	{
		printf("this is dijit");
	}else
	{
		printf("this is special");
	}
	
}
