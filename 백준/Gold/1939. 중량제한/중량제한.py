import sys
from collections import deque
input = sys.stdin.readline

def canReach(weight):
    queue = deque([start])
    visited = [False] * (N + 1)
    visited[start] = True
    while queue:
        node = queue.popleft()
        for next, cost in connected[node]:
            if visited[next] or cost < weight:
                continue
            visited[next] = True
            queue.append(next)
    return visited[end]

N, M = map(int, input().split())
connected = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B, C = map(int, input().split())
    connected[A].append([B, C])
    connected[B].append([A, C])

start, end = map(int, input().split())
left = 1
right = 1000000000
answer = 1
while left <= right:
    mid = (left + right) // 2
    if canReach(mid):
        left = mid + 1
        answer = mid
    else:
        right = mid - 1

print(answer)