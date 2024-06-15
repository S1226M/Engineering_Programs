#include<stdio.h>
void main(){
	char a;
	printf("plese enter a character\n");
	scanf("%c",&a);
	((a>='A' && a<='Z')||(a>='a' && a<='z'))?printf("alphabed"):printf("not");
	
}
