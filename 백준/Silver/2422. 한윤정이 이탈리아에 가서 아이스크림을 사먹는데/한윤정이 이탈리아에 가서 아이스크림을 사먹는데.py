import sys
input = sys.stdin.readline

n, m = map(int, input().split())
cannotSet = [set() for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    if a > b:
        a, b = b, a
    cannotSet[a].add(b)

count = 0
for i in range(1, n + 1):
    for j in range(i + 1, n + 1):
        if j in cannotSet[i]:
            continue
        for k in range(j + 1, n + 1):
            if k in cannotSet[i] or k in cannotSet[j]:
                continue
            count += 1

print(count)