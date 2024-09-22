from collections import deque
import sys
input = sys.stdin.readline

def get_connected_locations(field, x, y, visited):
    block = field[x][y]
    queue = deque()
    queue.append([x, y])
    connected_locations = [[x, y]]
    visited[x][y] = True
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if not (0 <= nx < height and 0 <= ny < width):
                continue
            if not visited[nx][ny] and field[nx][ny] == block:
                visited[nx][ny] = True
                queue.append([nx, ny])
                connected_locations.append([nx, ny])
    return connected_locations

def get_target_locations(field):
    visited = [[False for _ in range(width)] for _ in range(height)]
    target_locations = []
    for i in range(height - 1, -1, -1):
        for j in range(width):
            if visited[i][j] or field[i][j] == '.':
                continue
            locations = get_connected_locations(field, i, j, visited)
            if len(locations) >= 4:
                target_locations.extend(locations)
    return target_locations

# 1. 4개 이상 연결된 부분이 있는지 확인 -> 없으면 종료
# 2. 있으면 터뜨림 -> 터뜨린 열을 터뜨린 만큼 밑으로 보내기

height = 12
width = 6
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

field = list(list(input().rstrip()) for _ in range(height))
answer = 0

while True:
    locations = get_target_locations(field)
    if not locations: # 터질 곳이 없으면 종료
        break
    answer += 1
    counts = [0] * width
    starts = [0] * height
    for x, y in locations:
        counts[y] += 1
        starts[y] = max(starts[y], x)
        field[x][y] = '.'
    for j in range(width):
        count = counts[j]
        start = starts[j]
        if count == 0:
            continue
        for i in range(start - 1, -1, -1):
            if field[i][j] == '.':
                continue
            field[start][j] = field[i][j]
            field[i][j] = '.'
            start -= 1


print(answer)