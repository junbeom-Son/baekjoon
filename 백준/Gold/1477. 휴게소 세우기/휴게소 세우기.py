import sys
input = sys.stdin.readline

def getCountToBuild(length):
    count = 0
    for distance in distances:
        count += distance // length
        if distance % length == 0:
            count -= 1

    return count

N, M, L = map(int, input().split())
points = list(map(int, input().split()))
points.sort()
points.append(L)

distances = []
lastPoint = 0
for point in points:
    distances.append(point - lastPoint)
    lastPoint = point

left = 1
right = L - 1
answer = L - 1
while left <= right:
    mid = (left + right) // 2
    count = getCountToBuild(mid)
    if count <= M:
        right = mid - 1
        answer = mid
    else:
        left = mid + 1

print(answer)