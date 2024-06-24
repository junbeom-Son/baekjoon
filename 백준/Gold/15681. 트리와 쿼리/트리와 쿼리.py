from collections import deque
import sys
input = sys.stdin.readline

N, R, Q = map(int, input().split())
parents = [0] * (N + 1)
edges = [[] for _ in range(N + 1)]
children = [[] for _ in range(N + 1)]
size = [1] * (N + 1)
for _ in range(N - 1):
    a, b = map(int, input().split())
    edges[a].append(b)
    edges[b].append(a)

queries = list(int(input()) for _ in range(Q))
answers = []

queue = deque()
queue.append(R)
while queue:
    node = queue.popleft()
    for child in edges[node]:
        if child != parents[node]:
            parents[child] = node
            children[node].append(child)
            queue.append(child)

stack = []
visited = [False] * (N + 1)
stack.append(R)
while stack:
    node = stack.pop()
    if not visited[node] and children[node]:
        stack.append(node)
        visited[node] = True
        for child in children[node]:
            stack.append(child)
    else:
        size[parents[node]] += size[node]

for query in queries:
    answers.append(size[query])

print('\n'.join(map(str, answers)))