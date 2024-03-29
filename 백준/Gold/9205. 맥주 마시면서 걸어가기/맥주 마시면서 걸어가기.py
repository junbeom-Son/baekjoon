from collections import deque
import sys
input = sys.stdin.readline

T = int(input())
answers = []
for _ in range(T):
    n = int(input())
    positions = list(list(map(int, input().split())) for _ in range(n + 2))
    edges = [[] for _ in range(n + 2)]
    for i in range(n + 2):
        for j in range(i + 1, n + 2):
            distance = abs(positions[i][0] - positions[j][0]) + abs(positions[i][1] - positions[j][1])
            if distance <= 1000:
                edges[i].append(j)
                edges[j].append(i)

    queue = deque()
    queue.append(0)
    answer = 'sad'
    visited = [False] * (n + 2)
    while queue:
        number = queue.popleft()
        if number == n + 1:
            answer = 'happy'
            break
        for next in edges[number]:
            if not visited[next]:
                visited[next] = True
                queue.append(next)

    answers.append(answer)

print('\n'.join(answers))