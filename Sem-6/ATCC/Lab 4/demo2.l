%option noyywrap
%{
int c=0,l=0,w=0;
%}
%%
[a-zA-Z0-9]* {w++;c+=yyleng;}
. {c++;}
\n {c++;l++;}
%%
void main(){
		yyin=fopen("input.txt","r");
		yylex();
		printf("%d %d %d",c,w,l);
}