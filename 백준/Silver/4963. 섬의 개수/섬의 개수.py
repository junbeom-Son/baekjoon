from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

def visit(x, y, information, h, w):
    queue = deque()
    queue.append([x, y])
    while queue:
        x, y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < h and 0 <= ny < w and information[nx][ny] == 1:
                information[nx][ny] = 0
                queue.append([nx, ny])

def solution(information, w, h):
    count = 0
    for i in range(h):
        for j in range(w):
            if information[i][j] == 1:
                count += 1
                information[i][j] = 0
                visit(i, j, information, h, w)

    return count

answer = []
while True:
    w, h = map(int, input().split())
    if w == h == 0:
        break
    information = [list(map(int, input().split())) for _ in range(h)]
    answer.append(solution(information, w, h))

print('\n'.join(map(str, answer)))