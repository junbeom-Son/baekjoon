import sys
input = sys.stdin.readline
INF = 1000000000000000000

def canFinishInTime(t):
    count = 0
    for time in times:
        count += t // time
    return count >= M

N, M = map(int, input().split())
times = [int(input()) for _ in range(N)]
left = 1
right = INF
answer = INF
while left <= right:
    mid = (left + right) // 2
    if canFinishInTime(mid):
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)