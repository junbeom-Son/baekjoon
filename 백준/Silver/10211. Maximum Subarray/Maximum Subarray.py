import sys
input = sys.stdin.readline

t = int(input())
answer = []
for _ in range(t):
    n = int(input())
    X = [0] + list(map(int, input().split()))
    dp = [0] * (n + 1)
    for i in range(1, n + 1):
        dp[i] = X[i] + max(dp[i - 1], 0)

    answer.append(max(dp[1:]))

print('\n'.join(map(str, answer)))