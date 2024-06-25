import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
B = [-1] + list(reversed(A))
A = [-2] + A

LCS = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
for i in range(1, N + 1):
    for j in range(1, N + 1):
        LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1])
        if A[i] == B[j]:
            LCS[i][j] = max(LCS[i][j], LCS[i - 1][j - 1] + 1)

print(N - LCS[-1][-1])