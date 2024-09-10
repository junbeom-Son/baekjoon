import sys
input = sys.stdin.readline
n, k = map(int, input().split())
coins = list(int(input()) for _ in range(n))
dp = [0] * (k + 5)

for i in range(n):
    value = coins[i]
    if value > k:
        continue
    new_dp = [0] * (k + 5)
    new_dp[0] = 1
    for j in range(1, value):
        new_dp[j] = dp[j]
    for j in range(value, k + 1):
        new_dp[j] = dp[j] + new_dp[j - value]
    dp = new_dp
print(dp[k])