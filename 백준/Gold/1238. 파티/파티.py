import sys
import heapq
input = sys.stdin.readline
INF = 10000000

def calculateDistanceToX(departure):
    distancesToX = [1e9] * (n + 1)
    queue = []
    heapq.heappush(queue, (0, departure))
    distancesToX[departure] = 0
    while queue:
        distance, city = heapq.heappop(queue)
        if city == x:
            return distance
        if distancesToX[city] < distance:
            continue
        for nextCity, nextDistance in roads[city]:
            if distancesToX[nextCity] > distancesToX[city] + nextDistance:
                distancesToX[nextCity] = distancesToX[city] + nextDistance
                heapq.heappush(queue, (distance + nextDistance, nextCity))


def calculateDistanceFromX():
    distancesFromX = [INF] * (n + 1)
    queue = []
    heapq.heappush(queue, (0, x))
    while queue:
        distance, city = heapq.heappop(queue)
        if distance >= distancesFromX[city]:
            continue
        distancesFromX[city] = distance
        for nextCity, nextDistance in roads[city]:
            heapq.heappush(queue, (distance + nextDistance, nextCity))

    for i in range(1, n + 1):
        distances[i] += distancesFromX[i]

n, m, x = map(int, input().split())
roads = [[] for _ in range(n + 1)]
for _ in range(m):
    start, end, distance = map(int, input().split())
    roads[start].append([end, distance])

distances = [INF] * (n + 1)
distances[0] = 0
distances[x] = 0

for i in range(1, n + 1):
    distances[i] = calculateDistanceToX(i)

calculateDistanceFromX()

print(max(distances))