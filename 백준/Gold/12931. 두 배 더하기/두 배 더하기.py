import sys
input = sys.stdin.readline

n = int(input())
B = list(map(int, input().split()))
length = max(B)
doubles = [0] * (length + 5)
pluses = [0] * (length + 5)
pluses[1] = 1
for i in range(2, length + 1):
    if i % 2 == 0:
        doubleCount = doubles[i // 2] + pluses[i // 2]
        plusCount = doubles[i - 1] + pluses[i - 1]
        if doubleCount <= plusCount:
            doubles[i] = doubles[i // 2] + 1
            pluses[i] = pluses[i // 2]
        else:
            doubles[i] = doubles[i - 1]
            pluses[i] = pluses[i - 1] + 1
    else:
        doubles[i] = doubles[i - 1]
        pluses[i] = pluses[i - 1] + 1

count = max(doubles)
for number in B:
    count += pluses[number]

print(count)