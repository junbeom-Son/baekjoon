from collections import deque
import sys
input = sys.stdin.readline
dx = [-2, -2, -1, -1, 1, 1, 2, 2]
dy = [-1, 1, -2, 2, -2, 2, -1, 1]

def solution(l, sx, sy, tx, ty):
    queue = deque()
    queue.append([sx, sy, 0])
    visited = [[False for _ in range(l)] for _ in range(l)]
    visited[sx][sy] = True
    while queue:
        x, y, distance = queue.popleft()
        if x == tx and y == ty:
            return distance
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < l and 0 <= ny < l and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append([nx, ny, distance + 1])

T = int(input())
answer = []
for _ in range(T):
    l = int(input())
    sx, sy = map(int, input().split())
    tx, ty = map(int, input().split())
    answer.append(solution(l, sx, sy, tx, ty))

print('\n'.join(map(str, answer)))