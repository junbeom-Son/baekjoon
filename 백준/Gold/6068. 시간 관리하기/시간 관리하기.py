import sys
input = sys.stdin.readline
n = int(input())
works = [list(map(int, input().split())) for _ in range(n)]
works.sort(key = lambda x : -x[1])

startTime = 100000000
for i in range(n):
    endTime = min(startTime, works[i][1])
    startTime = endTime - works[i][0]

if startTime < 0:
    startTime = -1

print(startTime)