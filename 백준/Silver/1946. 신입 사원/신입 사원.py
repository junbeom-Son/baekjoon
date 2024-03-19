import sys
input = sys.stdin.readline

T = int(input())
answer = []
for _ in range(T):
    N = int(input())
    ranks = [list(map(int, input().split())) for _ in range(N)]
    ranks.sort(key = lambda x : x[0])
    minRank = N + 1
    count = 0
    for rank1, rank2 in ranks:
        if rank2 < minRank:
            minRank = rank2
            count += 1
    answer.append(count)

print('\n'.join(map(str, answer)))