import sys
input = sys.stdin.readline

def findGroup(number):
    if groups[number] != number:
        groups[number] = findGroup(groups[number])
    return groups[number]

def union(a, b):
    if a < b:
        groups[b] = a
    else:
        groups[a] = b

N, M = map(int, input().split())
edges = list(list(map(int, input().split())) for _ in range(M))
edges.sort(key=lambda x:x[2])

count = 0
groups = [i for i in range(N + 1)]
answer = 0
lastCost = 0

for a, b, cost in edges:
    a = findGroup(a)
    b = findGroup(b)
    if a != b:
        union(a, b)
        count += 1
        answer += cost
        lastCost = cost
        if count == N - 1:
            break

print(answer - lastCost)