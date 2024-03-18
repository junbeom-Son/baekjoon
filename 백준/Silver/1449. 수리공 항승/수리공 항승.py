import sys
input = sys.stdin.readline

N, L = map(int, input().split())
distances = list(map(int, input().split()))
distances.sort()

count = 0
lastBlocked = 0
for distance in distances:
    if distance > lastBlocked:
        count += 1
        lastBlocked = distance - 1 + L

print(count)