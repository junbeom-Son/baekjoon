import sys
input = sys.stdin.readline

def multiply(i, j, size):
    result = 0
    for k in range(size):
        result += A[i][k] * B[k][j]

    return result

N, M = map(int, input().split())
A = list(list(map(int, input().split())) for _ in range(N))
M, K = map(int, input().split())
B = list(list(map(int, input().split())) for _ in range(M))
C = [[0 for _ in range(K)] for _ in range(N)]
for i in range(N):
    for j in range(K):
        C[i][j] = multiply(i, j, M)

answer = []
for i in range(len(C)):
    answer.append(' '.join(map(str, C[i])))

print('\n'.join(answer))