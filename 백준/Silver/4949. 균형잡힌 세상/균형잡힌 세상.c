#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct stackNode {
	char ch;
	struct stackNode *link;
}stackNode;

int flag;
stackNode *top = NULL;

void push(char);
char pop(void);


int main() {
	char str[101] = { '\0' }, item;
	int index = 0;
	while(1){
		flag = 0;
		gets(str);
		if (str[0] == '.')
			break;
		else {
			for (int i = 0; i < strlen(str); i++) {
				if (str[i] == '(' || str[i] == '[') {
					push(str[i]);
				}
				else if (str[i] == ')') {
					item = pop();
					if (item != '(') {
						flag = 1;
						break;
					}
				}
				else if (str[i] == ']') {
					item = pop();
					if (item != '[') {
						flag = 1;
						break;
					}
				}
			}
		}
		if (top != NULL || flag == 1) {
			printf("no\n");
			top = NULL;
		}
		else
			printf("yes\n");
	}
	return 0;
}

void push(char c) {
	stackNode *newNode;
	newNode = (stackNode*)malloc(sizeof(stackNode));
	newNode->ch = c;
	newNode->link = top;
	top = newNode;
}
char pop(void) {
	if (top == NULL) {
		flag = 1;
		return;
	}
	stackNode *old = top;
	char item;
	item = top->ch;
	top = top->link;
	free(old);
	return item;
}