from collections import deque
import sys

def findIndex(number):
    for i in range(len(queue)):
        if queue[i] == number:
            return i

input = sys.stdin.readline

n, m = map(int, input().split())
elements = list(map(int, input().split()))

queue = deque(range(1, n + 1))

answer = 0
for element in elements:
    index = findIndex(element)
    if index <= len(queue) // 2:
        while queue[0] != element:
            queue.append(queue.popleft())
            answer += 1
    else:
        while queue[0] != element:
            queue.appendleft(queue.pop())
            answer += 1

    queue.popleft()

print(answer)