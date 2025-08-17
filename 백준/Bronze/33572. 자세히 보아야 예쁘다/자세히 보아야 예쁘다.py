def solution(counts, m):
    for count in counts:
        m -= (count - 1)
        if m <= 0:
            return 'DIMI'
    return 'DIMI' if m <= 0 else 'OUT'

n, m = map(int, input().split())
counts = list(map(int, input().split()))
print(solution(counts, m))