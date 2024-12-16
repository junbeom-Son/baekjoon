import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def initialize(board, N, M, visited, air_count_board):
    left_cheese = set()
    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                left_cheese.add(convert_x_y_to_position(i, j))

    return left_cheese

def count_air_connection(board, N, M, visited, air_count_board, air_queue):
    while air_queue:
        x, y = air_queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if not in_range(nx, ny, N, M):
                continue
            if visited[nx][ny]:
                continue
            if board[nx][ny] == 1:
                air_count_board[nx][ny] += 1
            else:
                visited[nx][ny] = True
                air_queue.append([nx, ny])

def find_targets(left_cheese, air_count_board):
    targets = []
    for position in left_cheese:
        x, y = convert_posiiton_to_x_y(position)
        if air_count_board[x][y] >= 2:
            targets.append([x, y])
    return targets

def in_range(x, y, N, M):
    return 0 <= x < N and 0 <= y < M

def convert_x_y_to_position(x, y):
    return x * 100 + y

def convert_posiiton_to_x_y(position):
    x = position // 100
    y = position % 100
    return x, y

N, M = map(int, input().split())
board = list(list(map(int, input().split())) for _ in range(N))
air_count_board = [[0 for _ in range(M)] for _ in range(N)]
visited = [[False for _ in range(M)] for _ in range(N)]

left_cheese = initialize(board, N, M, visited, air_count_board)
answer = 0
air_queue = deque()
air_queue.append([0, 0])
while left_cheese:
    count_air_connection(board, N, M, visited, air_count_board, air_queue)
    targets = find_targets(left_cheese, air_count_board)
    for x, y in targets:
        board[x][y] = 0
        position = convert_x_y_to_position(x, y)
        left_cheese.remove(position)
        air_queue.append([x, y])
        visited[x][y] = True
    answer += 1

print(answer)