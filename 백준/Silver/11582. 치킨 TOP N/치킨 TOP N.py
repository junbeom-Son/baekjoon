import sys
input = sys.stdin.readline

N = int(input())
stores = list(map(int, input().split()))
K = int(input())
unit = N // K
answer = []
tmp = []
for i in range(N):
    if i % unit == 0:
        tmp.sort()
        answer.extend(tmp)
        tmp.clear()
    tmp.append(stores[i])

tmp.sort()
answer.extend(tmp)

print(' '.join(map(str, answer)))