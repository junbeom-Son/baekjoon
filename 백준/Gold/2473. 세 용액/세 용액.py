import sys
input = sys.stdin.readline

INF = 5000000000

def initailizeWithOneCategory(values, answers, minValue, direction):
    if len(values) < 3:
        return INF
    if direction == 1:
        value = abs(sum(values[:3]))
        if value < minValue:
            for i in range(3):
                answers[i] = values[i]
            minValue = value
        return minValue
    value = abs(sum(values[-3:]))
    if value < minValue:
        for i in range(3):
            answers[i] = values[-(i + 1)]
        minValue = value
    return minValue

def calculateTwoCategories(listA, listB, answers, minValue, direction):
    if len(listA) < 2:
        return minValue
    if not listB:
        return minValue
    for i in range(len(listA) - 1):
        sum = listA[i]
        for j in range(i + 1, len(listA)):
            sum += listA[j]
            ceilingIndex = getCeilingIndex(abs(sum), listB, direction)
            value = abs(sum + listB[ceilingIndex])
            if value < minValue:
                minValue = value
                answers[:3] = [listA[i], listA[j], listB[ceilingIndex]]
            ceilingIndex -= direction
            if 0 <= ceilingIndex < len(listB):
                value = abs(sum + listB[ceilingIndex])
                if value < minValue:
                    minValue = value
                    answers[:3] = [listA[i], listA[j], listB[ceilingIndex]]
            sum -= listA[j]

    return minValue

def getCeilingIndex(value, targetList, direction): # 절대값이 value보다 큰 수 중 가장 작은 수의 인덱스를 찾는 것
    left = 0
    right = len(targetList) - 1
    answer = right
    if direction == 1 and targetList[-1] < value: # 모든 값이 가장 작다 -> 제일 큰 인덱스 반환
        return len(targetList) - 1
    if direction == -1 and -targetList[0] < value:
        return 0
    while left <= right:
        mid = (left + right) // 2
        if value <= abs(targetList[mid]):
            answer = mid
            if direction == 1:
                right = mid - 1
            else:
                left = mid + 1
        else:
            if direction == 1:
                left = mid + 1
            else:
                right = mid - 1
    return answer
    


N = int(input())
values = list(map(int, input().split()))
negatives = []
positives = []
portions = [0, 0, 0]

for value in values:
    if value < 0:
        negatives.append(value)
    else:
        positives.append(value)

negatives.sort()
positives.sort()

minValue = INF
minValue = initailizeWithOneCategory(positives, portions, minValue, 1)
minValue = initailizeWithOneCategory(negatives, portions, minValue, -1)
minValue = calculateTwoCategories(positives, negatives, portions, minValue, -1)
minValue = calculateTwoCategories(negatives, positives, portions, minValue, 1)
portions.sort()
print(' '.join(map(str, portions)))