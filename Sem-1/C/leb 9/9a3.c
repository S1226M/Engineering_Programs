#include<stdio.h>
void main(){
	int x,y,i=1,mul=1;
	printf("plese enter two number\n");
	scanf("%d %d",&x,&y);
	while(i<=y)
	{
		mul=mul*x;
		i++;
	}
	printf("%d",mul);
}
