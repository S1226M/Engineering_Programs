#include<stdio.h>
void main(){
	char A;
	printf("plese enter your character\n");
	scanf("%c",&A);
	if(A=='a'||A=='e'||A=='i'||A=='o'||A=='u')
	{
		printf("the character is vowel");
	}
	else
	{
		printf("the character is constant");
	}
}
