import heapq
import sys
input = sys.stdin.readline

N = int(input())
words = list(input().rstrip() for _ in range(N))

weights = dict()
for word in words:
    weight = 1
    length = len(word)
    for i in range(length):
        c = word[length - i - 1]
        if c not in weights:
            weights[c] = 0
        weights[c] += weight
        weight *= 10

orders = []
for c in weights:
    heapq.heappush(orders, (-weights[c], c))

weights = dict()
order = 9
while orders:
    weight, c = heapq.heappop(orders)
    weights[c] = order
    order -= 1

answer = 0
for word in words:
    length = len(word)
    value = 0
    weight = 1
    for i in range(length):
        c = word[length - i - 1]
        value += weights[c] * weight
        weight *= 10
    
    answer += value

print(answer)