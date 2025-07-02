#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Definition for singly-linked list.
struct ListNode {
    int val;
    struct ListNode *next;
};

// Function to detect cycle using Floyd's Tortoise and Hare algorithm
bool hasCycle(struct ListNode *head) {
    if (head == NULL || head->next == NULL)
        return false;

    struct ListNode *slow = head;
    struct ListNode *fast = head;

    while (fast != NULL && fast->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;

        if (slow == fast)
            return true;
    }

    return false;
}

// Helper function to create a new node
struct ListNode* createNode(int value) {
    struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
    newNode->val = value;
    newNode->next = NULL;
    return newNode;
}

int main() {
    // Creating nodes
    struct ListNode* head = createNode(3);
    head->next = createNode(2);
    head->next->next = createNode(0);
    head->next->next->next = createNode(-4);

    // Creating a cycle (tail connects to second node)
    head->next->next->next->next = head->next;  // Cycle here

    if (hasCycle(head)) {
        printf("Cycle detected in the linked list.\n");
    } else {
        printf("No cycle in the linked list.\n");
    }

    // WARNING: Memory not freed due to cycle.
    // In real applications, avoid memory leaks by breaking the cycle first.

    return 0;
}
