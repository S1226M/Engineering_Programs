#include <stdio.h>
void main()
{
    FILE *f;
    f = fopen("Try.txt", "r");
    char c;
    int sc=0,tc=0,cc=0,nlc=1;
    while (fscanf(f, "%c", &c) == 1)
    {
        if(c == '\t'){
            tc++;
        }
        else if(c == ' '){
            sc++;
        }
        else if(c == '\n'){
            nlc++;
        }
        else{
            cc++;
        }
        printf("%c", c);
    }
    printf("\n%d %d %d %d",tc,sc,nlc,cc);

}