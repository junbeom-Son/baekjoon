n = int(input()) % (15 * (100000))
dp = [0] * (n + 1)
dp[1] = 1
for i in range(2, n + 1):
    dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000

print(dp[n])