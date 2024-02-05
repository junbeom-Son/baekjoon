import sys
input = sys.stdin.readline
paper = [[False for _ in range(100)] for _ in range(100)]

n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    for i in range(10):
        for j in range(10):
            paper[x + i][y + j] = True

answer = 0
for i in range(100):
    for j in range(100):
        if paper[i][j]:
            answer += 1

print(answer)