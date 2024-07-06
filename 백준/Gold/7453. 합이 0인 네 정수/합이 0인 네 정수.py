import sys
input = sys.stdin.readline

n = int(input())
numbers = [list(map(int, input().split())) for _ in range(n)]

AB = []
for i in range(n):
    for j in range(n):
        AB.append(numbers[i][0] + numbers[j][1])

AB.sort()

CD = []
answer = 0
for i in range(n):
    for j in range(n):
        CD.append(numbers[i][2] + numbers[j][3])

CD.sort()

abIndex = 0
cdIndex = len(CD) - 1
while abIndex < len(AB) and cdIndex >= 0:
    if AB[abIndex] + CD[cdIndex] < 0:
        abIndex += 1
    elif AB[abIndex] + CD[cdIndex] > 0:
        cdIndex -= 1
    else:
        abCount = 0
        cdCount = 0
        abNumber = AB[abIndex]
        cdNumber = CD[cdIndex]
        while abIndex < len(AB) and AB[abIndex] == abNumber:
            abCount += 1
            abIndex += 1
        while cdIndex >= 0 and CD[cdIndex] == cdNumber:
            cdCount += 1
            cdIndex -= 1
        answer += abCount * cdCount

print(answer)