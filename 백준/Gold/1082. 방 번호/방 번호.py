import sys
input = sys.stdin.readline

N = int(input())
prices = list(map(int, input().split()))
M = int(input())

firstNumberPrice = 500
firstNumber = -1
minPrice = 500
minPriceNumber = -1
for i in range(N):
    if i > 0 and prices[i] <= firstNumberPrice:
        firstNumberPrice = prices[i]
        firstNumber = i
    if prices[i] <= minPrice:
        minPrice = prices[i]
        minPriceNumber = i

if firstNumberPrice > M:
    answer = [0]
else:
    answer = [firstNumber]
    M -= firstNumberPrice
    while M >= minPrice:
        answer.append(minPriceNumber)
        M -= minPrice

    for i in range(0, len(answer)):
        for j in range(N - 1, answer[i], -1):
            if M + prices[answer[i]] - prices[j] >= 0:
                M += prices[answer[i]]
                M -= prices[j]
                answer[i] = j
                break

print(''.join(map(str, answer)))