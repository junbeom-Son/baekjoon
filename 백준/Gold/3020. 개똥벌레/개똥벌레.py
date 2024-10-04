import sys
input = sys.stdin.readline

def get_count(numbers, height):
    left, right = 0, len(numbers) - 1
    index = -1
    while left <= right:
        mid = (left + right) // 2
        if numbers[mid] >= height:
            index = mid
            left = mid + 1
        else:
            right = mid - 1
    return index + 1

N, H = map(int, input().split())
heights = list(int(input()) for _ in range(N))
from_bottom = heights[::2]
from_top = heights[1::2]
from_bottom.sort()
from_bottom.reverse()
from_top.sort()
from_top.reverse()
min_count, count = 10000000, 0
for i in range(1, H + 1):
    current_count = get_count(from_bottom, i)
    current_count += get_count(from_top, (H - i) + 1)
    if current_count < min_count:
        min_count = current_count
        count = 1
    elif current_count == min_count:
        count += 1

print(min_count, count)