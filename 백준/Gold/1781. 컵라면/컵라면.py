import sys
import heapq
input = sys.stdin.readline

N = int(input())
noodlesByDeadline = dict()
for _ in range(N):
    deadline, noodle = map(int, input().split())
    if deadline not in noodlesByDeadline:
        noodlesByDeadline[deadline] = []
    noodlesByDeadline[deadline].append(noodle)

noodles = []
answer = 0
for deadline in range(max(noodlesByDeadline), 0, -1):
    if deadline in noodlesByDeadline:
        for noodle in noodlesByDeadline[deadline]:
            heapq.heappush(noodles, -noodle)
    
    if noodles:
        answer += -(heapq.heappop(noodles))

print(answer)