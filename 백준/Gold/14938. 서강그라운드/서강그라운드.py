import heapq
import sys
input = sys.stdin.readline

def getMaxItem(number):
    count = 0
    tmpDistances = [100000000] * (n + 1)
    tmpDistances[number] = 0
    queue = []
    heapq.heappush(queue, (0, number))
    while queue:
        distance, number = heapq.heappop(queue)
        if tmpDistances[number] != distance:
            continue
        count += items[number]
        for next in roads[number]:
            nextDistance = distance + distances[number][next]
            if nextDistance < tmpDistances[next] and distance + distances[number][next] <= m:
                tmpDistances[next] = nextDistance
                heapq.heappush(queue, (distance + distances[number][next], next))

    return count

n, m, r = map(int, input().split())
items = [0] + list(map(int, input().split()))
distances = [[1000000 for _ in range(n + 1)] for _ in range(n + 1)]
roads = [set() for _ in range(n + 1)]
for _ in range(r):
    a, b, l = map(int, input().split())
    roads[a].add(b)
    roads[b].add(a)
    distances[a][b] = min(distances[a][b], l)
    distances[b][a] = min(distances[b][a], l)

answer = 0
for i in range(1, n + 1):
    answer = max(answer, getMaxItem(i))

print(answer)