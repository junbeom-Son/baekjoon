import sys
input = sys.stdin.readline

n = int(input())
wines = [0] + [int(input()) for _ in range(n)] + [0, 0, 0, 0, 0]
dp = [0] * (n + 5)
dp[1] = wines[1]
dp[2] = wines[1] + wines[2]
for i in range(3, n + 1):
    dp[i] = max(dp[i - 1], max(dp[i - 3] + wines[i - 1], dp[i - 2]) + wines[i])

print(dp[n])