import sys
input = sys.stdin.readline

A = int(input())
numbers = list(map(int, input().split()))

increasing = [1] * A
decreasing = [1] * A

for i in range(1, A):
    for j in range(i):
        if numbers[i] > numbers[j]:
            increasing[i] = max(increasing[i], increasing[j] + 1)

        if numbers[A - i - 1] > numbers[A - j - 1]:
            decreasing[A - i - 1] = max(decreasing[A - i - 1], decreasing[A - j - 1] + 1)

answer = 1
for i in range(A):
    answer = max(answer, increasing[i] + decreasing[i] - 1)

print(answer)