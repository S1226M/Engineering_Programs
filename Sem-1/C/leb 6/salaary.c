#include<stdio.h>
void main(){
	int s;
	float HRA,DA,gs;
	printf("plese enter your salry\n");
	scanf("%d",&s);
	if(s>=30000)
	{
		HRA=(s*30)/100;
		DA=(s*95)/100;
		printf("your hra is:%f\n",HRA);
		printf("your da is:%f\n",DA);
		gs=s+HRA+DA;
		printf("your gross salary is:%f\n",gs);
	}
	else if(s>=20000)
	{
		HRA=(s*25)/100;
		DA=(s*90)/100;
		printf("your hra is:%f\n",HRA);
		printf("your da is:%f\n",DA);
		gs=s+HRA+DA;
		printf("your gross salary is:%f\n",gs);
	}
	if(s>=10000)
	{
		HRA=(s*20)/100;
		DA=(s*80)/100;
		printf("your hra is:%f\n",HRA);
		printf("your da is:%f\n",DA);
		gs=s+HRA+DA;
		printf("your gross salary is:%f\n",gs);
	}
}
