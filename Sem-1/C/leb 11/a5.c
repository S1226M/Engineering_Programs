#include<stdio.h>
void main(){
	int a,i,ans=1;
	printf("plese enter a number\n");
	scanf("%d",&a);
	for(i=a;i>0;i--)
	{
		ans=ans*i;
	}
	printf("%d",ans);
}
