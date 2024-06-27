import sys
input = sys.stdin.readline
INF = 1000000000

N, M = map(int, input().split())
scores = [[0 for _ in range(M + 1)]] + list([0] + list(map(int, input().split())) for _ in range(N))

increasingDP = [[0 for _ in range(M + 1)] for _ in range(N + 1)]
increasingDP[N][1] = scores[N][1]
for i in range(2, M + 1):
    increasingDP[N][i] = scores[N][i] + increasingDP[N][i - 1]

for i in range(N - 1, 0, -1):
    increasingDP[i][1] = scores[i][1] + increasingDP[i + 1][1]

for i in range(N - 1, 0, -1):
    for j in range(2, M + 1):
        increasingDP[i][j] = max(increasingDP[i+1][j], increasingDP[i][j-1]) + scores[i][j]

decreasingDP = [[-INF for _ in range(M + 1)] for _ in range(N + 1)]
for i in range(1, N + 1):
    for j in range(1, M + 1):
        decreasingDP[i][j] = max(increasingDP[i][j], max(decreasingDP[i-1][j], decreasingDP[i][j-1])) + scores[i][j]

print(decreasingDP[-1][-1])