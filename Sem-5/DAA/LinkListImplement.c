#include <stdio.h>
struct Node
{
    int data;
    struct Node *next;
} *head = NULL;

struct Node *createNewNode()
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->next = NULL;
    return newNode;
}

void InsertAtFirst(int n)
{
    struct Node *newNode = createNewNode();
    newNode->data = n;

    if (head == NULL)
    {
        printf("List is empty. Inserting first node.\n");
        newNode->next = NULL;
        head = newNode;
    }
    else
    {
        newNode->next = head;
        head = newNode;
    }
}

void InsertAtLast(int n)
{
    struct Node *newNode = createNewNode();
    newNode->data = n;
    newNode->next = NULL;

    if (head == NULL)
    {
        head = newNode;
        return;
    }

    struct Node *temp = head;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    temp->next = newNode;
}

int SizeOfLinkList()
{
    int count = 0;
    struct Node *temp = head;
    while (temp != NULL)
    {
        count++;
        temp = temp->next;
    }
    return count;
}

void InsertAtPosition(int n, int pos)
{
    int size = SizeOfLinkList();

    if (pos < 1 || pos > size + 1)
    {
        printf("Position is Not Valid\n");
        return;
    }

    struct Node *newNode = createNewNode();
    newNode->data = n;

    if (pos == 1)
    {
        newNode->next = head;
        head = newNode;
        return;
    }

    struct Node *temp = head;
    for (int i = 1; i < pos - 1; i++)
    {
        temp = temp->next;
    }

    newNode->next = temp->next;
    temp->next = newNode;
}

void DeleteAtFirst()
{
    if (head == NULL)
    {
        printf("List is empty. Nothing to delete.\n");
        return;
    }
    else if (head->next == NULL)
    {
        free(head);
        head = NULL;
        return;
    }
    else
    {
        struct Node *temp = head;
        head = head->next;
        temp->next = NULL;
        free(temp);
        return;
    }
}

void DeleteAtLast()
{
    struct Node *temp = head;
    struct Node *prev = head;
    temp = temp->next;

    while (temp->next != NULL)
    {
        prev = prev->next;
        temp = temp->next;
    }
    prev->next = NULL;
    free(temp);
}

void DeleteAtPosition(int pos)
{
    if (head == NULL)
    {
        printf("List is empty. Nothing to delete.\n");
        return;
    }
    else
    {
        int size = SizeOfLinkList();
        if (pos < 1 || pos > size)
        {
            printf("Invalid position");
            return;
        }

        if (pos == 1)
        {
            struct Node *temp = head;
            head = head->next;
            free(temp);
            return;
        }
        else
        {
            struct Node *temp = head;
            for (int i = 1; i < pos - 1; i++)
            {
                temp = temp->next;
            }
            struct Node *nodeToDelete = temp->next;
            if (nodeToDelete == NULL)
            {
                printf("Next node is NULL. Can't delete.\n");
                return;
            }
            else
            {
                temp->next = nodeToDelete->next;
                free(nodeToDelete);
            }
        }
    }
}

void Display()
{
    struct Node *temp = head;
    while (temp != NULL)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void SortLinkList()
{
    if (head == NULL)
    {
        printf("Underflow\n");
        return;
    }

    struct Node *first = head;
    struct Node *second = NULL;

    while (first != NULL && first->next != NULL)
    {
        second = first;
        while (second->next != NULL)
        {
            if (second->data > second->next->data)
            {
                int temp = second->data;
                second->data = second->next->data;
                second->next->data = temp;
            }
            second = second->next;
        }
        first = first->next;
    }
}

int main()
{
    InsertAtLast(3);
    InsertAtLast(10);
    InsertAtLast(7);
    InsertAtLast(5);
    InsertAtLast(1);
    Display();
    InsertAtPosition(9, 3);
    Display();
    DeleteAtFirst();
    Display();
    InsertAtFirst(11);
    Display();
    DeleteAtLast();
    Display();
    SortLinkList();
    Display();
    DeleteAtPosition(3);
    Display();
    return 0;
}