#include<stdio.h>
void main(){
	int i=1,a,table;
	printf("plese enter a number\n");
	scanf("%d",&a);
	while(i<=10)
	{
		table=a*i;
		printf("%d\n",table);
		i++;
	}
}
