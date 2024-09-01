def solution(heights):
    total = sum(heights)
    for i in range(len(heights) - 1):
        for j in range(i + 1, len(heights)):
            if total - heights[i] - heights[j] == 100:
                return set([i, j])

heights = list(int(input()) for _ in range(9))
not_included_index = solution(heights)
heights = [heights[i] for i in range(len(heights)) if i not in not_included_index]
heights.sort()
print('\n'.join(map(str, heights)))