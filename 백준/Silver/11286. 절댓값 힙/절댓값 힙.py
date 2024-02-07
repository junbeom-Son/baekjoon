import heapq
import sys

input = sys.stdin.readline

priorityQueue = []

def getMinimumValue():
    if not priorityQueue:
        return 0
    return heapq.heappop(priorityQueue)[1]

def solution():
    n = int(input())
    operations = [int(input()) for _ in range(n)]
    answer = []

    for operation in operations:
        if operation == 0:
            answer.append(getMinimumValue())
        if operation != 0:
            heapq.heappush(priorityQueue, (abs(operation), operation))
    return answer

print('\n'.join(map(str, solution())))