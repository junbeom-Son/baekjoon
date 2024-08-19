import sys
input = sys.stdin.readline

N, M = map(int, input().split())
J = int(input())
locations = list(int(input()) for _ in range(J))
left = 1
right = M
count = 0
for location in locations:
    if location < left:
        distance = left - location
        count += distance
        left = location
        right -= distance
    elif location > right:
        distance = location - right
        count += distance
        left += distance
        right += distance

print(count)