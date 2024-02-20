from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
inBounds = [0 for _ in range(n + 1)]
nextStudents = [[] for _ in range(n + 1)]
for _ in range(m):
    A, B = map(int, input().split())
    nextStudents[A].append(B)
    inBounds[B] += 1

answer = []
queue = deque()
for i in range(1, n + 1):
    if inBounds[i] == 0:
        queue.append(i)

while queue:
    student = queue.popleft()
    answer.append(student)
    for nextStudent in nextStudents[student]:
        inBounds[nextStudent] -= 1
        if inBounds[nextStudent] == 0:
            queue.append(nextStudent)

print(*answer)