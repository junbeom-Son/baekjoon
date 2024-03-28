import sys
input = sys.stdin.readline

N, M = map(int, input().split())
apps = [[] for _ in range(N)]
inputs = [list(map(int, input().split())) for _ in range(2)]
for j in range(2):
    for i in range(N):
        apps[i].append(inputs[j][i])

apps.sort(key = lambda x : (x[1], -x[0]))
apps = [[0, 0]] + apps

costSum = sum(inputs[1])
dp = [[0 for _ in range(costSum + 1)] for _ in range(N + 1)]
for i in range(1, N + 1):
    memory = apps[i][0]
    cost = apps[i][1]
    for j in range(costSum + 1):
        if j < cost:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - cost] + memory)

for i in range(costSum + 1):
    if dp[-1][i] >= M:
        print(i)
        break