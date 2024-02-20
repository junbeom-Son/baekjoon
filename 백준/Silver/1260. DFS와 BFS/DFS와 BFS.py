import sys

def dfs(node):
    print(node, end=' ')
    visited[node] = True
    for nextNode in nextNodes[node]:
        if not visited[nextNode]:
            dfs(nextNode)

n, m, v = map(int, sys.stdin.readline().split())
visited = [False] * (n + 1)
nextNodes = [[] for i in range(n + 1)]
for _ in range(m):
    n1, n2 = map(int, sys.stdin.readline().split())
    nextNodes[n1].append(n2)
    nextNodes[n2].append(n1)

for i in range(1, n + 1):
    nextNodes[i].sort()
dfs(v)
print()
visited = [False] * (n + 1)
queue = [v]
visited[v] = True
while queue:
    head = queue.pop(0)
    print(head, end=' ')
    for nextNode in nextNodes[head]:
        if not visited[nextNode]:
            visited[nextNode] = True
            queue.append(nextNode)