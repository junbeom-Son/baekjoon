import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def calculate(x, y, groupNumber):
    visited[x][y] = True
    queue = deque([[x, y]])
    groups = [[x, y]]
    count = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and gameMap[nx][ny] == '0' and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append([nx, ny])
                groups.append([nx, ny])
                count += 1
    
    for x, y in groups:
        counts[x][y] = count
        groupNumbers[x][y] = groupNumber

def getResult(x, y):
    count = 1
    group = set()
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if 0 <= nx < N and 0 <= ny < M and groupNumbers[nx][ny] not in group:
            count += counts[nx][ny]
            group.add(groupNumbers[nx][ny])

    return count % 10

N, M = map(int, input().split())
gameMap = list(input().rstrip() for _ in range(N))
visited = [[False for _ in range(M)] for _ in range(N)]
counts = [[0 for _ in range(M)] for _ in range(N)]
results = [[0 for _ in range(M)] for _ in range(N)]
groupNumbers = [[0 for _ in range(M)] for _ in range(N)]
number = 1

for i in range(N):
    for j in range(M):
        if gameMap[i][j] == '0' and not counts[i][j]:
            calculate(i, j, number)
            number += 1

for i in range(N):
    for j in range(M):
        if gameMap[i][j] == '1':
            results[i][j] = getResult(i, j)

print('\n'.join(''.join(map(str, results[i])) for i in range(N)))