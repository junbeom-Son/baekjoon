import sys
input = sys.stdin.readline

T = int(input())
answer = []
for _ in range(T):
    N = int(input())
    wCounts = [0, 0]
    ocellos = list(input().rstrip() for _ in range(2))
    diffCount = 0
    for i in range(N):
        for j in range(2):
            if ocellos[j][i] == 'W':
                wCounts[j] += 1
        if ocellos[0][i] != ocellos[1][i]:
            diffCount += 1
    count = abs(wCounts[0] - wCounts[1])
    diffCount -= count
    count += diffCount // 2
    if diffCount % 2 == 1:
        count += 1
    answer.append(count)


print('\n'.join(map(str, answer)))