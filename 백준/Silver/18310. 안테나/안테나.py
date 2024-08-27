MAX_DISTANCE = 100000

N = int(input())
locations = list(map(int, input().split()))
counts = [0] * (MAX_DISTANCE + 1)
for location in locations:
    counts[location] += 1

left = 0
right = N
answer = 0
totalDistance = sum(locations)
minDistance = totalDistance

for i in range(1, MAX_DISTANCE + 1):
    totalDistance += left
    totalDistance -= right
    left += counts[i]
    right -= counts[i]
    if totalDistance < minDistance:
        minDistance = totalDistance
        answer = i

print(answer)