import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

def divide(count):
    left, right = 1, count
    while left <= right:
        mid = (left + right) // 2
        after_divide = mid * 2 + K
        if after_divide == count: # K 차이로 구분지을 수 있는 경우
            return [mid, mid + K]
        if after_divide < count:
            left = mid + 1
        else:
            right = mid - 1

    return [-1]

def commence(count):
    group_count = 1
    sub_groups = divide(count)
    if len(sub_groups) == 1:
        counts[count] = group_count
        return group_count
    group_count = 0
    for sub_group in sub_groups:
        if sub_group in counts:
            group_count += counts[sub_group]
            continue
        group_count += commence(sub_group)

    counts[count] = group_count
    return group_count

N, K = map(int, input().split())
counts = dict()
print(commence(N))