from bisect import bisect_left
import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
numbers = []
for number in A:
    idx = bisect_left(numbers, number)
    if idx == len(numbers):
        numbers.append(number)
    else:
        numbers[idx] = number

print(len(numbers))