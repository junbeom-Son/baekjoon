import sys
input = sys.stdin.readline

N, T = map(int, input().split())
carrots = list(list(map(int, input().split())) for _ in range(N))
carrots.sort(key = lambda x : x[1])
start = T - N
answer = 0
for i in range(N):
    answer += carrots[i][0] + carrots[i][1] * (start + i)

print(answer)