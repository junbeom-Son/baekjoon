N, M = map(int, input().split())
numbers = list(map(int, input().split()))

def getSectionCount(targetScore):
    count = 0
    maxValue = 10000000000
    minValue = 10000000000
    for number in numbers:
        if abs(number - maxValue) > targetScore or abs(number - minValue) > targetScore:
            count += 1
            maxValue = number
            minValue = number
        else:
            maxValue = max(maxValue, number)
            minValue = min(minValue, number)
    
    return count

left = 0
right = 10000
answer = 10000
while left <= right:
    mid = (left + right) // 2
    sectionCount = getSectionCount(mid)
    if sectionCount <= M:
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)