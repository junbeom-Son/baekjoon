import sys
input = sys.stdin.readline

n = int(input())
balloons = list(map(int, input().split()))
heights = dict()

for balloon in balloons:
    if balloon + 1 in heights:
        heights[balloon + 1] -= 1
        if heights[balloon + 1] == 0:
            del heights[balloon + 1]

    heights[balloon] = heights.get(balloon, 0) + 1

count = 0
for key in heights:
    count += heights[key]

print(count)