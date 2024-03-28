from collections import deque
import sys
input = sys.stdin.readline

def getFirstPosition():
    for i in range(R):
        for j in range(C):
            if forest[i][j] == 'S':
                return i, j

def getInitialWaterPositions():
    positions = []
    for i in range(R):
        for j in range(C):
            if forest[i][j] == water:
                positions.append([i, j])
    return positions

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

R, C = map(int, input().split())
forest = [list(input().rstrip()) for _ in range(R)]
answer = 'KAKTUS'
water = '*'
target = 'D'
firstX, firstY = getFirstPosition()
waterPositions = getInitialWaterPositions()
queue = deque()
queue.append([0, firstX, firstY])
visited = [[False for _ in range(C)] for _ in range(R)]
visited[firstX][firstY] = True
time = 0
while queue:
    curTime, x, y = queue.popleft()
    if forest[x][y] == target:
        answer = curTime
        break

    if curTime == time:
        time += 1
        newWaterPositions = []
        for waterX, waterY in waterPositions:
            for i in range(4):
                nx = waterX + dx[i]
                ny = waterY + dy[i]
                if 0 <= nx < R and 0 <= ny < C and forest[nx][ny] == '.':
                    forest[nx][ny] = '*'
                    newWaterPositions.append([nx, ny])

    waterPositions = newWaterPositions
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < R and 0 <= ny < C and (forest[nx][ny] == '.' or forest[nx][ny] == target) and not visited[nx][ny]:
            visited[nx][ny] = True
            queue.append([curTime + 1, nx, ny])

print(answer)