import sys
input = sys.stdin.readline

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
i, j = 0, 0
count = 0
total = 0
while True:
    if total < M:
        if j == N:
            break
        total += numbers[j]
        j += 1
    else:
        if total == M:
            count += 1
        total -= numbers[i]
        i += 1

print(count)