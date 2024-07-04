import sys
input = sys.stdin.readline

positions = {'U': [-1, 0], 'D': [1, 0], 'L': [0, -1], 'R': [0, 1]}

def search(x, y, number):
    while True:
        if visited[x][y] != -1 and visited[x][y] < number:
            return 0
        if visited[x][y] == number:
            break
        visited[x][y] = number
        dx, dy = positions.get(area[x][y])
        x += dx
        y += dy

    return 1

N, M = map(int, input().split())
area = list(input().rstrip() for _ in range(N))
count = 0
number = 0
visited = [[-1 for _ in range(M)] for _ in range(N)]
for i in range(N):
    for j in range(M):
        if visited[i][j] != -1: # 이미 방문된 구역은 방문 x
            continue
        count += search(i, j, number)
        number += 1

print(count)