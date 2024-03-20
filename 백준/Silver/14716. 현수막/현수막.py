from collections import deque
import sys
input = sys.stdin.readline

M, N = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(M)]

dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]

def bfs(x, y):
    queue = deque()
    queue.append([x, y])
    board[x][y] = 0
    while queue:
        x, y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N and board[nx][ny] == 1:
                board[nx][ny] = 0
                queue.append([nx, ny])

count = 0
for i in range(M):
    for j in range(N):
        if board[i][j] == 1:
          bfs(i, j)
          count += 1

print(count)