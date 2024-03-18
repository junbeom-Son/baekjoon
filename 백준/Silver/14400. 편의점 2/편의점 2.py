import sys
input = sys.stdin.readline

def getOptimalDistance(positions):
    distance = 0
    positionCounts = {}
    for position in positions:
        positionCounts[position] = positionCounts.get(position, 0) + 1
        distance += (position - positions[0])
    left = positionCounts[positions[0]]
    right = len(positions) - left
    optimalDistance = distance
    for i in range(positions[0] + 1, positions[-1] + 1):
        distance += left
        distance -= right
        optimalDistance = min(optimalDistance, distance)
        if i in positionCounts:
            left += positionCounts[i]
            right -= positionCounts[i]

    return optimalDistance



n = int(input())
xPositions = []
yPositions = []
for _ in range(n):
    x, y = map(int, input().split())
    xPositions.append(x)
    yPositions.append(y)

xPositions.sort()
yPositions.sort()
print(getOptimalDistance(xPositions) + getOptimalDistance(yPositions))