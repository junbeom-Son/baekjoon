n, k = map(int, input().split())
coins = [0] + list(set(int(input()) for _ in range(n)))
coins.sort()
n = len(coins) - 1

values = [[-1 for _ in range(k + 1)] for _ in range(n + 1)]
for i in range(n + 1):
    values[i][0] = 0

for i in range(1, n + 1):
    coin = coins[i]
    for j in range(1, min(coin, k + 1)):
        values[i][j] = values[i - 1][j]
    for j in range(coin, k + 1):
        if values[i - 1][j] == -1:
            if values[i][j - coin] == -1:
                values[i][j] = -1
            else:
                values[i][j] = values[i][j - coin] + 1
        elif values[i][j - coin] == -1:
            values[i][j] = values[i - 1][j]
        else:
            values[i][j] = min(values[i][j - coin] + 1, values[i - 1][j])

print(values[-1][-1])