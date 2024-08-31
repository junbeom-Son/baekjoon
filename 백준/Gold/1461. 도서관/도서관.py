def extractGroups(positions, M, groups):
    while positions:
        count = 0
        groups.append(positions[-1])
        while positions and count < M:
            count += 1
            positions.pop()

N, M = map(int, input().split())
positions = list(map(int, input().split()))
positives = []
negatives = []
for position in positions:
    if position < 0:
        negatives.append(-position)
    else:
        positives.append(position)

positives.sort()
negatives.sort()
groups = []
extractGroups(positives, M, groups)
extractGroups(negatives, M, groups)
answer = sum(groups) * 2
answer -= max(groups)
print(answer)