def extractNumbers(number):
    minResult = []
    maxResult = []
    while number > 0:
        digit = number % 10
        if digit in (5, 6):
            minResult.append(5)
            maxResult.append(6)
        else:
            minResult.append(digit)
            maxResult.append(digit)
        number //= 10
    minValue = 0
    maxValue = 0
    for i in range(len(minResult) - 1, -1, -1):
        minValue *= 10
        maxValue *= 10
        minValue += minResult[i]
        maxValue += maxResult[i]
    return minValue, maxValue

numbers = list(map(int, input().split()))
mins = [0, 0]
maxs = [0, 0]

for i in range(2):
    mins[i], maxs[i] = extractNumbers(numbers[i])

print(sum(mins), sum(maxs))
