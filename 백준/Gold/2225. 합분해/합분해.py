N, K = map(int,input().split())
answer = [[0 for _ in range(N + 1)] for _ in range(K + 1)]

answer[0][0] = 1
for i in range(K + 1):
    answer[i][0] = 1

for i in range(N + 1):
    answer[1][i] = 1

for i in range(2, K + 1):
    for j in range(1, N + 1):
        answer[i][j] = (answer[i - 1][j] + answer[i][j - 1]) % 1000000000

print(answer[K][N])