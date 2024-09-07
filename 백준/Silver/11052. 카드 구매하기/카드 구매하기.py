N = int(input())
prices = [0] + list(map(int, input().split()))
dp = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
for i in range(1, N + 1):
    price = prices[i]
    for j in range(1, N + 1):
        dp[i][j] = dp[i-1][j]
        if j >= i:
            dp[i][j] = max(dp[i][j], dp[i][j-i] + price)

print(dp[-1][-1])