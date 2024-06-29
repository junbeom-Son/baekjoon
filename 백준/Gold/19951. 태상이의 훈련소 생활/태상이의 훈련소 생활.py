import sys
input = sys.stdin.readline

def getSize(N):
    size = 2
    while size < N:
        size *= 2
    return size

def updateRange(index, left, right, a, b, k):
    if left > b or right <= a: # 범위를 벗어난 경우 -> 아무 연산 x
        return
    if a <= left and right - 1 <= b: # 범위에 완전 포함된 경우 -> 해당 위치에 update check
        tree[index] += k
        return
    updateRange(index * 2, left, (left + right) // 2, a, b, k)
    updateRange(index * 2 + 1, (left + right) // 2, right, a, b, k)

N, M = map(int, input().split())
size = getSize(N)
tree = [0] * (size * 2)
heights = list(map(int, input().split()))
for i in range(N):
    tree[i+size] = heights[i]
commands = list(list(map(int, input().split())) for _ in range(M))

for a, b, k in commands:
    updateRange(1, 1, size + 1, a, b, k)

for i in range(1, size):
    tree[i * 2] += tree[i]
    tree[i * 2 + 1] += tree[i]

print(' '.join(map(str, tree[size:size+N])))