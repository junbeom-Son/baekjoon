# 1. 2차원 Map 형태로 홈 위치 저장
# 2. 0, 0부터 BFS
 
# BFS
# 방문 처리 : 2차원 Map에 저장
# 방문 여부 : 2차원 Map에 있는지 확인

from collections import deque
import sys
input = sys.stdin.readline

n, T = map(int, input().split())
positions = dict()
for _ in range(n):
    x, y = map(int, input().split())
    if x not in positions:
        positions[x] = set()
    positions[x].add(y)

queue = deque()
queue.append([0, 0, 0])
answer = -1
visited = dict()
while queue:
    distance, x, y = queue.popleft()
    if y == T:
        answer = distance
        break

    for i in range(-2, 3):
        nx = x + i
        if nx < 0 or nx not in positions: # 범위 밖이거나, 홈이 없다면 패스
            continue
        for j in range(-2, 3):
            ny = y + j
            if ny < 0 or ny not in positions[nx]:
                continue

            if nx not in visited:
                visited[nx] = set()
            if ny not in visited[nx]:
                visited[nx].add(ny)
                queue.append([distance + 1, nx, ny])

print(answer)