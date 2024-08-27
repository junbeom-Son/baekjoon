import sys
input = sys.stdin.readline

N = int(input())
predicts = list(int(input()) for _ in range(N))
predicts.sort()
rank = 1
answer = 0
for predict in predicts:
    answer += abs(rank - predict)
    rank += 1

print(answer)