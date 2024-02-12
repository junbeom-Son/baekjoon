import sys

class Node:
    def __init__(self, value):
        self.value = value
        self.prev = None
        self.next = None

    def add(self, value):
        node = Node(value)
        if self.next:
            node.next = self.next
            self.next.prev = node
        self.next = node
        node.prev = self
        return self.next

    def delete(self):
        if not self.prev:
            return self
        self.prev.next = self.next
        self.next.prev = self.prev
        return self.prev

    def move(self, direction):
        if direction == '<':
            if self.prev:
                return self.prev
        else:
            if self.next.next:
                return self.next
        return self

n = int(input())
answer = []
directions = set(('<', '>'))
for _ in range(n):
    tmp = []
    head = Node('')
    head.add('')
    cursor = head
    s = input().rstrip()
    for c in s:
        if c in directions:
            cursor = cursor.move(c)
        elif c == '-':
            cursor = cursor.delete()
        else:
            cursor = cursor.add(c)

    cursor = head.next
    while cursor.next:
        tmp.append(cursor.value)
        cursor = cursor.next

    answer.append(''.join(tmp))

print('\n'.join(answer))