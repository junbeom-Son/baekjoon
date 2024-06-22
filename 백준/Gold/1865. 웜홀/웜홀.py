import sys
input = sys.stdin.readline
INF = 1000000000

def hasCycle(edges, N, start, visited):
    distances = [INF] * (N + 1)
    distances[start] = 0
    for i in range(N):
        for start in edges.keys():
            if distances[start] == INF:
                continue
            for end in edges[start].keys():
                if distances[end] > distances[start] + edges[start][end]:
                    distances[end] = distances[start] + edges[start][end]
                    visited[end] = True

                    if i == N - 1:
                        return True
    
    return False

def solution(edges, N):
    visited = [False] * (N + 1)
    for i in range(N + 1):
        if not visited[i]:
            visited[i] = True
            if hasCycle(edges, N, i, visited):
                return "YES"
            
    return "NO"

TC = int(input())
answer = []
for _ in range(TC):
    N, M, W = map(int, input().split())
    edges = dict()
    for _ in range(M):
        s, e, cost = map(int, input().split())
        if s not in edges:
            edges[s] = dict()
        if e not in edges:
            edges[e] = dict()
        edges[s][e] = min(edges[s].get(e, INF), cost)
        edges[e][s] = min(edges[e].get(s, INF), cost)
    
    for _ in range(W):
        s, e, cost = map(int, input().split())
        if s not in edges:
            edges[s] = dict()
        edges[s][e] = min(edges[s].get(e, INF), -cost)

    answer.append(solution(edges, N))

print('\n'.join(answer))