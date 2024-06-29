import sys
input = sys.stdin.readline

N, M = map(int, input().split())

heights = [0] + list(map(int, input().split()))
commands = list(list(map(int, input().split())) for _ in range(M))
changes = [0] * (N + 2)
for a, b, k in commands:
    changes[a] += k
    changes[b + 1] -= k

for i in range(1, N + 1):
    changes[i] += changes[i - 1]

for i in range(1, N + 1):
    heights[i] += changes[i]

print(' '.join(map(str, heights[1:N + 1])))