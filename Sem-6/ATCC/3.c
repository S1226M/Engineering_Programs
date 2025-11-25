#include <stdio.h>
#include <ctype.h>
void main()
{
    FILE *f;
    f = fopen("Try.txt", "r");
    char c;
    char temp;

    fscanf(f, "%c", &c);
    temp = toupper(c);
    printf("%c", temp);
    while (fscanf(f, "%c", &c) == 1)
    {
        printf("%c", c);
        if (c == ' ' || c == '\n')
        {
            fscanf(f, "%c", &c);
            temp = toupper(c);
            printf("%c", temp);
        }
    }
}