import sys
input = sys.stdin.readline

N, M = map(int, input().split())
words = list(input().rstrip() for _ in range(N))
orders = []
for i in range(1, N):
    if words[i][0] >= 'a' and words[i][0] <= 'z':
        orders.append(i)

for i in range(N - 1, 0, -1):
    if words[i][0] >= 'A' and words[i][0] <= 'Z':
        orders.append(i)

totalLength = 0
for word in words:
    totalLength += len(word)

totalLength = M - totalLength
baseCount = totalLength // (N - 1)
totalLength = totalLength % (N - 1)
count = [0] + ([baseCount] * (N - 1))

for i in range(totalLength):
    order = orders[i]
    count[order] += 1

answer = []
for i in range(N):
    answer.append('_' * count[i])
    answer.append(words[i])
print(''.join(answer))