import heapq
import sys
input = sys.stdin.readline

N = int(input())
scoresByDeadline = dict()
for _ in range(N):
    deadline, score = map(int, input().split())
    if deadline not in scoresByDeadline:
        scoresByDeadline[deadline] = []
    scoresByDeadline[deadline].append(score)

scores = []
answer = 0
for i in range(max(scoresByDeadline), 0, -1):
    if i in scoresByDeadline:
        for score in scoresByDeadline[i]:
            heapq.heappush(scores, -score)
    if scores:
        answer += -(heapq.heappop(scores))

print(answer)