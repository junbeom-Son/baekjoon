import sys
input = sys.stdin.readline

n = int(input())
numbers = list(int(input()) for _ in range(n))
LIS = [1] * n
for i in range(1, n):
    for j in range(i):
        if numbers[j] < numbers[i] and LIS[j] >= LIS[i]:
            LIS[i] = LIS[j] + 1

print(n - max(LIS))