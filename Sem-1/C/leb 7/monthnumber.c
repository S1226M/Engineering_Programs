#include<stdio.h>
void main(){
	int a;
	printf("plese enter a month number");
	scanf("%d",&a);
	if(a>=1&&a<=12)
	{
	
	switch(a){
	
	case 2:printf("28 days");
	break;
	case 4:
	case 6:
	case 9:
	case 11:printf("30 days");
	break;
	default:
		printf("31 days");
	}
	}
	else
	printf("plese enter a velid month number");
}
