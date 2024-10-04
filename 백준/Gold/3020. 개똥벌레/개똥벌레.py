import sys
input = sys.stdin.readline

N, H = map(int, input().split())
heights = list(int(input()) for _ in range(N))
from_bottom = heights[::2]
from_top = heights[1::2]
from_bottom_counts = [0] * (H + 1)
from_top_counts = [0] * (H + 1)
for number in from_bottom:
    from_bottom_counts[number] += 1
for number in from_top:
    from_top_counts[number] += 1

for i in range(1, H + 1):
    from_bottom_counts[i] += from_bottom_counts[i - 1]
    from_top_counts[i] += from_top_counts[i - 1]

min_count, count = 100000000, 0
for i in range(1, H + 1):
    bottom_count = from_bottom_counts[H] - from_bottom_counts[i - 1]
    top_count = from_top_counts[H] - from_top_counts[H - i]
    total_count = bottom_count + top_count
    if total_count < min_count:
        min_count = total_count
        count = 1
    elif total_count == min_count:
        count += 1
print(min_count, count)