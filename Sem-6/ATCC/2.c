#include <stdio.h>
void main()
{
    FILE *f;
    f = fopen("Try.txt", "r");
    char c;
    FILE *fp;
    fp = fopen("CopyTry.txt", "a");
    while (fscanf(f, "%c", &c) == 1)
    {
        fprintf(fp, "%c", c);
    }
    fclose(f);
    fclose(fp);
}