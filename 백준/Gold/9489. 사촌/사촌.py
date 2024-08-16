from collections import deque
import sys
input = sys.stdin.readline
INF = 1000005

def solution(k, numbers, parents, depths):
    siblings = []
    queue = deque()
    queue.append(numbers[0])
    depths[numbers[0]] = 0
    index = 1
    while queue:
        parent = queue.popleft()
        depth = depths[parent]
        if depth >= len(siblings):
            siblings.append([])
        siblings[depth].append(parent)
        firstChild = True
        while index < len(numbers):
            number = numbers[index]
            if not firstChild and numbers[index - 1] + 1 < number:
                break
            firstChild = False
            depths[number] = depth + 1
            parents[number] = parent
            index += 1
            queue.append(number)
        
    targetDepth = depths[k]
    if targetDepth <= 1:
        return 0
    targetParent = parents[k]
    targetGrandParent = parents[targetParent]
    count = 0
    for sibling in siblings[targetDepth]:
        parent = parents[sibling]
        grandParent = parents[parent]
        if  parent != targetParent and targetGrandParent == grandParent:
            count += 1

    return count

answers = []
parents = [0] * INF
depths = [0] * INF
while True:
    n, k = map(int, input().split())
    if n == 0 and k == 0:
        break
    numbers = list(map(int, input().split()))
    answers.append(solution(k, numbers, parents, depths))

print('\n'.join(map(str, answers)))