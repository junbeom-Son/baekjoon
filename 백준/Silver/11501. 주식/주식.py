import sys
T = int(input())
answers = []
for _ in range(T):
    N = int(input())
    prices = list(map(int, input().split()))
    postMaxes = [0] * N
    lastMax = 0
    for i in range(N - 1, -1, -1):
        postMaxes[i] = lastMax
        lastMax = max(lastMax, prices[i])
    
    maxProfit = 0
    for i in range(N):
        profit = postMaxes[i] - prices[i]
        if profit > 0:
            maxProfit += profit
    answers.append(maxProfit)

print('\n'.join(map(str, answers)))