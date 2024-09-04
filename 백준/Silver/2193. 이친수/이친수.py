def solution(N):
    dp = [0] * (N + 5)
    dp[1] = 1
    dp[2] = 1
    for i in range(3, N + 1):
        dp[i] = dp[i - 2] + dp[i - 1]
    return dp[N]

N = int(input())
print(solution(N))