def getMinTwoAdjacentPlane(dice, excludeNumbers):
    minPlanes = 1000
    for i in range(len(dice) - 1):
        if i in excludeNumbers:
            continue
        for j in range(i + 1, len(dice)):
            if j in excludeNumbers: # 제외시킬 숫자
                continue
            if i + j == 5: # 마주보는 면
                continue
            minPlanes = min(minPlanes, dice[i] + dice[j])
    return minPlanes

def getMinThreeAdjacentPlane(dice):
    minPlanes = 1000
    for i in range(len(dice)):
        minPlanes = min(minPlanes, dice[i] + getMinTwoAdjacentPlane(dice, set([i, 5 - i])))
    return minPlanes

    
def solution(N, dice):
    if N == 1:
        return sum(dice) - max(dice)
    minTwoAdjacentPlane = getMinTwoAdjacentPlane(dice, set())
    minThreeAdjacePlane = getMinThreeAdjacentPlane(dice)
    answer = minTwoAdjacentPlane * 4 * (N - 1)
    answer += minThreeAdjacePlane * 4
    if N > 2:
        answer += 4 * (N - 2) * minTwoAdjacentPlane
        answer += ((4 * (N - 1) * (N - 2)) + ((N - 2) * (N - 2))) * min(dice)

    return answer

N = int(input())
dice = list(map(int, input().split()))
print(solution(N, dice))