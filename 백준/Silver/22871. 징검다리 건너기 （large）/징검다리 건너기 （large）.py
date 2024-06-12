import sys
input = sys.stdin.readline
INF = 5000000000

N = int(input())
powers = list(map(int, input().split()))
minPowers = [INF] * N
minPowers[0] = 0
for i in range(N):
    for j in range(i + 1, N):
        minPowers[j] = min(minPowers[j], max(minPowers[i], (j - i) * (1 + abs(powers[i] - powers[j]))))

print(minPowers[-1])