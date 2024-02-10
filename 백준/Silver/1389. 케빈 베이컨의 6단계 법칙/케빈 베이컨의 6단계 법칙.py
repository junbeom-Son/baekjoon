from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
relationships = [set() for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    relationships[a].add(b)
    relationships[b].add(a)

kevinBacon = [[-1 for _ in range(n + 1)] for _ in range(n + 1)]
minKevinBacon = 1e9
minKevinNumber = 1e9
for i in range(1, n + 1):
    queue = deque()
    for j in relationships[i]:
        kevinBacon[i][j] = 0
        queue.append(j)

    while queue:
        number = queue.popleft()
        for friend in relationships[number]:
            if kevinBacon[i][friend] == -1:
                kevinBacon[i][friend] = kevinBacon[i][number] + 1
                queue.append(friend)

    total = sum(kevinBacon[i][1:])
    if total < minKevinBacon:
        minKevinBacon = total
        minKevinNumber = i

print(minKevinNumber)