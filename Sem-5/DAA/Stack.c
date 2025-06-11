#include<stdio.h>
# define size 100
int stack [size];
int top = -1;

void push(int data){
    if(top == 101){
        printf("Stack Overflow");
    }
    else{
        printf("%d",data);
        stack[++top] = data;
    }
}

int Pop(){
    if(top == -1){
        printf("Stack Underflow");
    }
    else{
        return stack[top--];
    }
}

void Peep(){
    if(top == -1){
        printf("Stack is empty");
    }
    else{
        printf("%d",stack[top]);
    }        
}

void Change(int data,int Pos){
    if(top == -1){
        printf("Stack is empty");
    }
    else{
        if((top - Pos + 1) <= -1 || (top - Pos)<=0){
            printf("Invalid Position");
        }
        else{
            stack[top - Pos + 1] = data;
        }
    }
}

void Display(){
    int i;
    for(i = 0; i <= top ; i++){
        printf("%d ", stack[i]);
    }
}

void main(){
    while (1){
    int n;
    int data;
    int place;
    int ans;
    printf("Enter Digit 1 for Push :\n");
    printf("Enter Digit 2 for Pop :\n");
    printf("Enter Digit 3 for Peep :\n");
    printf("Enter Digit 4 for Change :\n");
    printf("Enter Digit 5 for Display :\n");
    printf("Enter Data :\n");
    scanf("%d",&n);
        switch (n)
        {
        case 1:
            printf("Enter Data to Push\n");
            int temp;
            scanf("%d",&temp);
            push(temp);
            break;
        case 2:
            ans = Pop();
            printf("%d",ans);
            break;
        case 3:
            Peep();
            break;
        case 4:
            scanf("%d",&data);
            scanf("%d",&place);
            Change(data,place);
            break;
        case 5:
            Display();
            break;
        }
    }
    
}