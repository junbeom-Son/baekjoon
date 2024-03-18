import sys
input = sys.stdin.readline

N = int(input())
scores = list(int(input()) for _ in range(N))
answer = 0
for i in range(N - 2, -1, -1):
    if scores[i] >= scores[i + 1]:
        tmp = scores[i]
        scores[i] = scores[i + 1] - 1
        answer += tmp - scores[i]

print(answer)