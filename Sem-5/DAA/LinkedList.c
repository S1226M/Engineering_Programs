#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int data;
    struct Node *next;
};
void insertAtLast(struct Node **head, int element);
void displayList(struct Node *head);
void deleteAtLast(struct Node** head);
void main()
{
    struct Node *head = NULL;
    int choice, value;
    do
    {
        printf("\nMenu:\n");
        printf("1. Insert at end\n");
        printf("2. Display list\n");
        printf("3. Delete At Last\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            printf("Enter value to insert at the end: ");
            scanf("%d", &value);
            insertAtLast(&head, value);
            break;

        case 2:
            printf("Current linked list:\n");
            displayList(head);
            break;
        case 3:
            printf("Delete At Last:\n");
            deleteAtLast(&head);
            break;
        case 4:
            printf("Exiting the program.\n");
            break;

        default:
            printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 4);
}

void insertAtLast(struct Node **head, int element)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    struct Node *temp = *head;
    newNode->data = element;
    newNode->next = NULL;
    if (*head == NULL)
    {
        *head = newNode;
        return;
    }

    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    temp->next = newNode;
}

void deleteAtLast(struct Node** head)
{
    if (*head == NULL)
    {
        printf("Linked list is empty");
        return;
    }
    if((*head)->next==NULL){
        *head=NULL;
        return;
    }
    struct Node* temp = *head;
    struct Node* prev = *head;
    while (temp->next != NULL)
    {
        prev = temp;
        temp = temp->next;
    }
    printf("Deleted %d",prev->next->data);
    prev->next = NULL;
}

void displayList(struct Node *head)
{
    if (head == NULL)
    {
        printf("Linked List Empty");
        return;
    }
    struct Node *temp = head;
    while (temp != NULL)
    {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL");
}
