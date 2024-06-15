#include<stdio.h>
void main(){
	int a,i,ans=1;
	scanf("%d",&a);
	i=a;
	while(i>0)
	{
		
		ans=ans*i;
		i--;
	}
	printf("%d",ans);
}
