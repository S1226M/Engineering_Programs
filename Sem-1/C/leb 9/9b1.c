#include<stdio.h>
void main(){
	char ch;
	ch='a';
	while(ch<='z')
	{
		printf("%c",ch);
		ch++;
	}
	printf("\n");
	ch='A';
	while(ch<='Z')
	{
		printf("%c",ch);
		ch++;
	}
	
}
