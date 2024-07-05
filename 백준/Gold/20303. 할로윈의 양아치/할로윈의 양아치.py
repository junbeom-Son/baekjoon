import sys
input = sys.stdin.readline

def find(a):
    if group[a] != a:
        group[a] = find(group[a])
    return group[a]

def union(a, b):
    if a < b:
        group[b] = group[a]
        candies[a] += candies[b]
        counts[a] += counts[b]
    else:
        group[a] = group[b]
        candies[b] += candies[a]
        counts[b] += counts[a]

N, M, K = map(int, input().split())
candies = [0] + list(map(int, input().split()))
group = [i for i in range(N + 1)]
counts = [1] * (N + 1)
for _ in range(M):
    a, b = map(int, input().split())
    a = find(a)
    b = find(b)
    if a == b:
        continue
    union(a, b)

items = [[counts[i], candies[i]] for i in range(N + 1) if group[i] == i]
knapsack = [[0 for _ in range(K)] for _ in range(len(items))]
for i in range(1, len(items)):
    count, candy = items[i]
    for j in range(min(count, K)):
        knapsack[i][j] = knapsack[i-1][j]
    for j in range(count, K):
        knapsack[i][j] = max(knapsack[i-1][j], knapsack[i-1][j-count] + candy)

print(knapsack[-1][-1])