from collections import deque

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(n)]
chickens = []
houses = []
for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            houses.append([i, j])
        elif city[i][j] == 2:
            chickens.append([i, j])

INF = 2000000000
result = INF
selectedChickens = set()
def selectMChickenHouse(index, count):
    global result
    if count == m:
        result = min(result, calculateChickenDistance())
        return
    if len(chickens) - index + 1 < m - count:
        return
    for i in range(index, len(chickens)):
        if i not in selectedChickens:
            selectedChickens.add(i)
            selectMChickenHouse(i + 1, count + 1)
            selectedChickens.remove(i)

def calculateChickenDistance():
    queue = deque()
    distances = [[INF for _ in range(n)] for _ in range(n)]
    for selectedChicken in selectedChickens:
        x, y = chickens[selectedChicken]
        queue.append([x, y])
        distances[x][y] = 0

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nextX = x + dx[i]
            nextY = y + dy[i]
            if nextX < 0 or nextX == n or nextY < 0 or nextY == n:
                continue
            if distances[nextX][nextY] > distances[x][y] + 1:
                distances[nextX][nextY] = distances[x][y] + 1
                queue.append([nextX, nextY])
    distance = 0
    for x, y in houses:
        distance += distances[x][y]
    return distance

selectMChickenHouse(0, 0)
print(result)