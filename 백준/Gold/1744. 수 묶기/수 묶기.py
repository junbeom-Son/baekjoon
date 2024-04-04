import sys
input = sys.stdin.readline

N = int(input())
positives = []
negatives = []
zero = 0
for _ in range(N):
    number = int(input())
    if number == 0:
        zero += 1
    elif number > 0:
        positives.append(number)
    else:
        negatives.append(number)

positives.sort()
negatives.sort(key = lambda x : -x)
answer = 0
while len(positives) > 1:
    n1, n2 = positives.pop(), positives.pop()
    answer += max(n1 + n2, n1 * n2)

if positives:
    answer += positives.pop()

while len(negatives) > 1:
    n1, n2 = negatives.pop(), negatives.pop()
    answer += n1 * n2

if negatives:
    if zero == 0:
        answer += negatives.pop()

print(answer)