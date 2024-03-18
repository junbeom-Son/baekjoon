# 1. 나무가 자라는 길이를 기준으로 오름차순으로 정렬
# 2. 적게 자라는 나무부터 하나씩 자름
n = int(input())
inputs = [list(map(int, input().split())) for _ in range(2)]
trees = []
for i in range(n):
    trees.append([inputs[0][i], inputs[1][i]])
trees.sort(key=lambda x:x[1])
answer = 0
for i in range(n):
    answer += trees[i][0] + trees[i][1] * i
print(answer)