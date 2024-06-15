#include<stdio.h>
#include<math.h>
void main(){
	int sec;
	int s,m,h;
	printf("plese enter second\n");
	scanf("%d",&sec);
	h=sec/3600;
	m=(sec-h*3600)/60;
	s=sec-(h*3600)-(m*60);
	printf("%d %d %d",h,m,s);
}
