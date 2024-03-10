import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
answer = 0
for i in range(n):
    if b[i] > a[i]:
        answer += b[i] - a[i]

print(answer)