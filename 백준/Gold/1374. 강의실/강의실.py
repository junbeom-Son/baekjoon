import heapq
import sys
input = sys.stdin.readline

n = int(input())
lectures = [list(map(int, input().split())) for _ in range(n)]
lectures.sort(key = lambda x : x[1])

hq = []
for number, start, end in lectures:
    if hq and hq[0] <= start:
        heapq.heappop(hq)
    heapq.heappush(hq, end)

print(len(hq))