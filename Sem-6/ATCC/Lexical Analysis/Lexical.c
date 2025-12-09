#include <stdio.h>
void main()
{
    FILE *f;
    f = fopen("Code.txt", "r");
    FILE *fp;
    fp = fopen("CopyCode.txt", "a");
    char c = fgetc(f);
    while (c != EOF)
    {
        if (c == '/')
        {
            c = fgetc(f);
            if (c == '/')
            {
                while (c != '\n')
                {
                    c = fgetc(f);
                }
            }
            else if (c == '*')
            {
                if (c == '*')
                {
                    c = fgetc(f);
                    if (c == '/')
                    {
                        c = fgetc(f);
                    }
                    else
                    {
                        while (1)
                        {
                            c = fgetc(f);
                            if (c == '*')
                            {
                                c = fgetc(f);
                                if (c == '/')
                                {
                                    c = fgetc(f);
                                    break;
                                }
                            }
                        }
                    }
                }
                else
                {
                    c = fgetc(f);
                }
            }
            else
            {
                fprintf(fp, "/");
            }
        }
        else
        {
            fprintf(fp, "%c", c);
            c = fgetc(f);
        }
    }
    fclose(f);
    fclose(fp);
}