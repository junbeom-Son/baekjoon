from collections import deque
import copy
import heapq
import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
keys = set(('a', 'b', 'c', 'd', 'e', 'f'))
doors = set(('A', 'B', 'C', 'D', 'E', 'F'))
keyDoorPairs = dict({'A':'a', 'B':'b', 'C':'c', 'D':'d', 'E':'e', 'F':'f'})

def getStartPosition():
    global maze
    for i in range(N):
        for j in range(M):
            if maze[i][j] == '0':
                maze[i][j] = '.'
                return i, j

N, M = map(int, input().split())
maze = [list(input().rstrip()) for _ in range(N)]
startX, startY = getStartPosition()
visited = [[set() for _ in range(M)] for _ in range(N)]

answer = -1
queue = deque()
emptyKey = ''
visited[startX][startY].add('')
# 거리, x, y, 키, 키 목록 큐, 키 셋
queue.append((0, startX, startY, emptyKey, [emptyKey], set(emptyKey)))
while queue:
    distance, x, y, key, keyQ, keySet = queue.popleft()
    if maze[x][y] == '1':
        answer = distance
        break
    if maze[x][y] in keys:
        if maze[x][y] not in keySet:
            keySet.add(maze[x][y])
            visited[x][y].add(maze[x][y])
            heapq.heappush(keyQ, maze[x][y])
            key = ''.join(keyQ)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and key not in visited[nx][ny] and (maze[nx][ny] == '.' or maze[nx][ny] in keys or (maze[nx][ny] in doors and keyDoorPairs.get(maze[nx][ny]) in keySet or maze[nx][ny] == '1')):
            visited[nx][ny].add(key)
            queue.append((distance + 1, nx, ny, copy.copy(key), copy.copy(keyQ), copy.copy(keySet)))

print(answer)