import sys
input = sys.stdin.readline

def find(number):
    if groups[number] != number:
        groups[number] = find(groups[number])
    return groups[number]

n, m = map(int, input().split())
genders = ['.'] + list(input().split())

edges = [list(map(int, input().split())) for _ in range(m)]

edges.sort(key = lambda x : x[2])

groups = [i for i in range(n + 1)]
count = 0
answer = 0
for u, v, weight in edges:
    if genders[u] == genders[v]:
        continue
    groupA = find(u)
    groupB = find(v)
    if groupA == groupB:
        continue
    count += 1
    answer += weight
    if count == n - 1:
        break
    if groupA < groupB:
        groups[groupB] = groupA
    else:
        groups[groupA] = groupB

if count < n - 1:
    answer = -1
print(answer)