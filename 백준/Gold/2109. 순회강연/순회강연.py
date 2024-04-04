import heapq
import sys
input = sys.stdin.readline

n = int(input())
prices = [[] for _ in range(10001)]
for _ in range(n):
    p, d = map(int, input().split())
    prices[d].append(p)

pq = []
answer = 0
for i in range(10000, 0, -1):
    for price in prices[i]:
        heapq.heappush(pq, -price)
    if pq:
        answer += -heapq.heappop(pq)

print(answer)