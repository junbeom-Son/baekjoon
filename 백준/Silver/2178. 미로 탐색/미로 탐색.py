import sys

from collections import deque

input = sys.stdin.readline

def solution():
    n, m = map(int, input().split())
    maze = [list(input().strip()) for _ in range(n)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    return getMinimumStep(n, m, maze, dx, dy)

def getMinimumStep(n, m, maze, dx, dy):
    steps = [[0 for _ in range(m)] for _ in range(n)]
    row = 0
    col = 0
    queue = deque()
    steps[row][col] = 1
    queue.append([row, col])
    while queue:
        curRow, curCol = queue.popleft()
        for i in range(4):
            nextRow = curRow + dx[i]
            nextCol = curCol + dy[i]
            if inRange(nextRow, nextCol, n, m) and maze[nextRow][nextCol] == '1' and not steps[nextRow][nextCol]:
                steps[nextRow][nextCol] = steps[curRow][curCol] + 1
                if nextRow + 1 == n and nextCol + 1 == m:
                    break
                queue.append([nextRow, nextCol])
    return steps[n - 1][m - 1]

def inRange(row, col, n, m):
    if row < 0 or col < 0 or row == n or col == m:
        return False
    return True

print(solution())