#include <stdio.h>
#define size 10
int queue[size];
int front = -1;
int rear = -1;
void Enqueue(int data)
{
    if (rear == size - 1)
    {
        printf("Queue is full\n");
    }
    else
    {
        if (front == -1)
        {
            front = 0;
        }
        else
        {
            rear = rear + 1;
            queue[rear] = data;
        }
    }
}

void display()
{
}
void main()
{
    while (1)
    {
        printf("Enter 1 for enqueue")
            printf("Enter 2 for dequeue")
                printf("Enter 3 for display")
                    printf("Enter n :") switch (n)
        {
        case 1:

            break;

        default:
            break;
        }
    }
}