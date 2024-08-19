import sys
input = sys.stdin.readline

N = int(input())
heights = list(map(int, input().split()))
start = heights[0]
maxCount = 0
count = 0
for i in range(1, N):
    if heights[i] < start:
        count += 1
    else:
        maxCount = max(maxCount, count)
        count = 0
        start = heights[i]

print(max(maxCount, count))