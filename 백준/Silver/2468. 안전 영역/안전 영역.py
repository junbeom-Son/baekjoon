from collections import deque
import sys
input = sys.stdin.readline
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def initializeMap(heights, N):
    heightOrder = set()
    heightPositions = dict()
    for i in range(N):
        for j in range(N):
            height = heights[i][j]
            heightOrder.add(height)
            if height not in heightPositions:
                heightPositions[height] = []
            heightPositions[height].append([i, j])
    heightOrder = sorted(list(heightOrder))

    return heightOrder, heightPositions

def visit(flooded, visited, N, x, y):
    queue = deque()
    queue.append([x, y])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and not flooded[nx][ny]:
                visited[nx][ny] = True
                queue.append([nx, ny])

def getSafeAreaCount(height, flooded, heightPositions, N):
    for x, y in heightPositions[height]:
        flooded[x][y] = True
    visited = [[False for _ in range(N)] for _ in range(N)]
    count = 0
    for i in range(N):
        for j in range(N):
            if not flooded[i][j] and not visited[i][j]:
                count += 1
                visited[i][j] = True
                visit(flooded, visited, N, i, j)

    return count

N = int(input())
heights = [list(map(int, input().split())) for _ in range(N)]
flooded = [[False for _ in range(N)] for _ in range(N)]
answer = 1
heightOrder, heightPositions = initializeMap(heights, N)
for height in heightOrder:
    answer = max(answer, getSafeAreaCount(height, flooded, heightPositions, N))

print(answer)