import sys
input = sys.stdin.readline

class Node:
    def __init__(self, c):
        self.value = c
        self.next = None
        self.prev = None

def goLeft():
    global cursor
    if cursor.prev:
        cursor = cursor.prev

def goRight():
    global cursor
    if cursor.next:
        cursor = cursor.next

def delete():
    global cursor
    if cursor.prev:
        cursor.prev = cursor.prev.prev
        if cursor.prev:
            cursor.prev.next = cursor


def add(value):
    global cursor
    node = Node(value)
    if cursor.prev:
        cursor.prev.next = node
        node.prev = cursor.prev

    node.next = cursor
    cursor.prev = node

s = input().rstrip()
m = int(input())

cursor = Node(s[0])
for i in range(1, len(s)):
    node = Node(s[i])
    node.prev = cursor
    cursor.next = node
    cursor = node

node = Node(' ')
node.prev = cursor
cursor.next = node
cursor = node

for _ in range(m):
    command = input().rstrip()
    if len(command) > 1:
        add(command[-1])
    elif command == 'L':
        goLeft()
    elif command == 'D':
        goRight()
    else:
        delete()

while cursor.prev:
    cursor = cursor.prev
answer = []
while cursor.next:
    answer.append(cursor.value)
    cursor = cursor.next

print(''.join(answer))