#include<stdio.h>
struct sturec{
	char name[30];
	char branch[30];
	int marks;
};
void main(){
	int i;
	struct sturec s1[2];
	for(i=0;i<2;i++)
	{
		printf("plese enter %d student name:-\n",i+1);
		scanf("%s",&s1[i].name);
	}
	for(i=0;i<2;i++)
	{
		printf("plese enter %d student branch:-\n",i+1);
		scanf("%s",&s1[i].branch);
	}
	for(i=0;i<2;i++)
	{
		printf("plese enter %d student marks:-\n",i+1);
		scanf("%d",&s1[i].marks);
	}
	for(i=0;i<2;i++)
	{
		printf("%s\n",s1[i].name);
		printf("%s\n",s1[i].branch);
		printf("%d\n",s1[i].marks);
	}
	
}
