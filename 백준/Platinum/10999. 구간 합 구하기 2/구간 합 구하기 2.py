import sys
input = sys.stdin.readline

def getSize(N):
    size = 2
    while size < N:
        size *= 2

    return size

def lazyUpdate(index, left, right):
    if updateRecords[index] == 0:
        return
    tree[index] += updateRecords[index] * (right - left)
    if index < size:
        updateRecords[index * 2] += updateRecords[index]
        updateRecords[index * 2 + 1] += updateRecords[index]
    updateRecords[index] = 0

def updateRange(index, left, right, s, e, value): # right는 범위 끝 + 1 -> 포함되지 않음
    if index < size + N:
        lazyUpdate(index, left, right)
    if left > e or right <= s:
        return
    if s <= left and right - 1 <= e: # 범위에 완전 포함
        tree[index] += value * (right - left)
        if index < size: # 자식이 있는 경우, 업데이트할 값 표시
            updateRecords[index * 2] += value
            updateRecords[index * 2 + 1] += value
        return
    updateRange(index * 2, left, (left + right) // 2, s, e, value)
    updateRange(index * 2 + 1, (left + right) // 2, right, s, e, value)
    tree[index] = tree[index * 2] + tree[index * 2 + 1]

def getSumInRange(index, left, right, s, e): # right는 범위 끝 + 1 -> 포함되지 않음
    if index < size + N:
        lazyUpdate(index, left, right)
    if left > e or right <= s: # 범위 미포함 -> 연산 x
        return 0
    if s <= left and right - 1 <= e: # 범위 완전 포함 -> 값 넘겨줌
        return tree[index]
    sum = 0
    sum += getSumInRange(index * 2, left, (left + right) // 2, s, e)
    sum += getSumInRange(index * 2 + 1, (left + right) // 2, right, s, e)
    return sum

N, M, K = map(int, input().split())
size = getSize(N)
tree = [0] * (size * 2)
for i in range(N):
    tree[i + size] = int(input())

for i in range(size - 1, 0, -1):
    tree[i] = tree[i * 2] + tree[i * 2 + 1]

updateRecords = [0] * (size * 2)
half = size // 2
queries = list(list(map(int, input().split())) for _ in range(M + K))
answer = []
for query in queries:
    command = query[0]
    if command == 1: # 구간 업데이트
        s, e, value = query[1:]
        updateRange(1, 1, size + 1, s, e, value)
    else:
        s, e = query[1:]
        answer.append(getSumInRange(1, 1, size + 1, s, e))

print('\n'.join(map(str, answer)))