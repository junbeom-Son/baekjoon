import heapq
T = int(input())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
INF = 1000000000
answer = []
for t in range(1, T + 1):
    N = int(input())
    gameMap = list(list(map(int, list(input()))) for _ in range(N))
    times = [[INF for _ in range(N)] for _ in range(N)]
    times[0][0] = 0
    pq = []
    heapq.heappush(pq, (0, (0, 0)))
    while pq:
        time, position = heapq.heappop(pq)
        x, y = position
        if x == N - 1 and y == N - 1:
            break
        if times[x][y] < time:
            continue

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and times[nx][ny] > time + gameMap[nx][ny]:
                heapq.heappush(pq, (time + gameMap[nx][ny], (nx, ny)))
                times[nx][ny] = time + gameMap[nx][ny]
    answer.append(f'#{t} {times[-1][-1]}')

print('\n'.join(answer))