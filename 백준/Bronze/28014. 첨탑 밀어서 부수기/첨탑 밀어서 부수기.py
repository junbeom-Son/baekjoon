n = int(input())
towers = list(map(int, input().split()))
answer = 1
for i in range(1, n):
    if towers[i] >= towers[i - 1]:
        answer += 1

print(answer)