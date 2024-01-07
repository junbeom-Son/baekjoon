from collections import deque
import sys
input = sys.stdin.readline
INF = int(1e9)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def calculateDistance(startX, startY):
    distances = [[INF for _ in range(m)] for _ in range(n)]
    distances[startX][startY] = 1
    queue = deque()
    queue.append([startX, startY])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nextX = x + dx[i]
            nextY = y + dy[i]
            if 0 <= nextX < n and 0 <= nextY < m and distances[x][y] + 1 < distances[nextX][nextY]:
                distances[nextX][nextY] = distances[x][y] + 1
                if maps[nextX][nextY] == 0:
                    queue.append([nextX, nextY])
    return distances

n, m = map(int, input().split())
maps = [list(map(int, list(input().rstrip()))) for _ in range(n)]

distanceFromStart = calculateDistance(0, 0)
distanceFromEnd = calculateDistance(n - 1, m - 1)

answer = distanceFromStart[-1][-1]
for i in range(n):
    for j in range(m):
        if maps[i][j] == 1:
            answer = min(answer, distanceFromStart[i][j] + distanceFromEnd[i][j] - 1)
if answer == INF:
    answer = -1
print(answer)