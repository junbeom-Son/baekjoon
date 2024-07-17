from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
priorities = [list(map(int, input().split())) for _ in range(M)]
X = int(input())
higherPriorityWorks = [[] for _ in range(N + 1)]
queue = deque()
queue.append(X)
proceeded = set()
proceeded.add(X)
for a, b in priorities:
    higherPriorityWorks[b].append(a)

count = 0
while queue:
    work = queue.popleft()
    for higherPriorityWork in higherPriorityWorks[work]:
        if higherPriorityWork not in proceeded:
            proceeded.add(higherPriorityWork)
            queue.append(higherPriorityWork)
            count += 1

print(count)