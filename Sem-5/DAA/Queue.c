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
        return;
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

int Dequeue()
{
    int Dequeuedata;
    if (front == -1)
    {
        printf("Queue is empty\n");
    }
    else
    {
        Dequeuedata = queue[front];
        if (front == rear)
        {
            front = -1;
            rear = -1;
        }
        else
        {
            front = front + 1;
        }
    }
    return Dequeuedata;
}

void display()
{
    int i;
    if (front == -1)
    {
        printf("Queue is empty\n");
    }
    else
    {
        printf("Queue elements are:\n");
        for (int i = front; i <= rear; i++)
        {
            printf("%d ", queue[i]);
        }
    }
}
void main()
{
    int n;
    int data;
    int Ans;
    while (1)
    {
        printf("Enter 1 for enqueue");
        printf("Enter 2 for dequeue");
        printf("Enter 3 for display");
        printf("Enter n :");
        scanf("%d", &n);
        switch (n)
        {
        case 1:
            printf("Enter data to be inserted: ");
            scanf("%d", &data);
            Enqueue(data);
            break;

        case 2:
            printf("Dequeue Element is :");
            Ans = Dequeue();
            printf("%d\n", &Ans);
            break;

        case 3:
            display();
            break;

        default:
            break;
        }
    }
}