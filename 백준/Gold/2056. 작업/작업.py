from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
workingTime = [0 for _ in range(n + 1)]
finishTime = [0 for _ in range(n + 1)]
inbounds = [0 for _ in range(n + 1)]
nextWorks = [[] for _ in range(n + 1)]
queue = deque()
for i in range(1, n + 1):
    workInformation = list(map(int, input().split()))
    workingTime[i] = workInformation[0]
    inbounds[i] = workInformation[1]
    if inbounds[i] > 0:
        for j in range(2, len(workInformation)):
            nextWorks[workInformation[j]].append(i)
    else:
        queue.append(i)

answer = 0
while queue:
    work = queue.popleft()
    finishTime[work] += workingTime[work]
    answer = max(answer, finishTime[work])
    for nextWork in nextWorks[work]:
        inbounds[nextWork] -= 1
        finishTime[nextWork] = max(finishTime[nextWork], finishTime[work])
        if inbounds[nextWork] == 0:
            queue.append(nextWork)

print(answer)