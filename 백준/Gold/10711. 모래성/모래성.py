from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

def get_destroy_count(x, y):
    count = 0
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if beach[nx][ny] == 0:
            count += 1
    return count

H, W = map(int, input().split())
beach = list(list(input().rstrip()) for _ in range(H))
destroyed = [[False for _ in range(W)] for _ in range(H)]
for i in range(H):
    for j in range(W):
        if beach[i][j] == '.':
            beach[i][j] = 0
            destroyed[i][j] = True
        else:
            beach[i][j] = int(beach[i][j])

destroy_counts = [[0 for _ in range(W)] for _ in range(H)]

queue = deque()
for i in range(1, H - 1):
    for j in range(1, W - 1):
        destroy_counts[i][j] = get_destroy_count(i, j)
        if destroy_counts[i][j] >= beach[i][j] and beach[i][j] > 0: # 삭제될 대상이라면
            queue.append([i, j])
            destroyed[i][j] = True

answer = 0
while queue:
    answer += 1
    nextQueue = deque()
    while queue:
        x, y = queue.popleft()
        beach[x][y] = 0
        for i in range(8):
            nx = dx[i] + x
            ny = dy[i] + y
            destroy_counts[nx][ny] += 1
            if not destroyed[nx][ny] and destroy_counts[nx][ny] >= beach[nx][ny]:
                nextQueue.append([nx, ny])
                destroyed[nx][ny] = True
                changed = True
                
    queue = nextQueue

print(answer)