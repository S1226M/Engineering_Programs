#include <stdio.h>
struct node
{
    int info;
    struct node *link;
};

void display(struct node *ptr)
{
    while (ptr != NULL)
    {
        printf("%d->", ptr->info);
        ptr = ptr->link;
    }
    printf("NULL\n");
}

void reverse(struct node *temp)
{
    struct node *first = temp;
    struct node *second = temp->link;
    struct node *last = temp;
    int count = 1;
    while (last->link != NULL)
    {
        last = last->link;
        count++;
    }
    printf("%d", last->info);

    for (int i = 0; i < count; i++)
    {
        last->link = first;
        last = first;
        first = second;
        last->link = NULL;
        second = second->link;
    }

    printf("%d", first->info);
    printf("%d", second->info);
    printf("%d", last->info);
}

void main()
{
    struct node *head = (struct node *)malloc(sizeof(struct node));
    struct node *first = (struct node *)malloc(sizeof(struct node));
    struct node *secound = (struct node *)malloc(sizeof(struct node));
    struct node *third = (struct node *)malloc(sizeof(struct node));
    struct node *forth = (struct node *)malloc(sizeof(struct node));
    head->info = 32;

    head->link = first;
    first->info = 33;
    first->link = secound;

    secound->info = 22;
    secound->link = third;

    third->info = 25;
    third->link = forth;

    forth->info = 18;
    forth->link = NULL;

    display(head);
    reverse(head);
}