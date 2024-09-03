import heapq
import sys
input = sys.stdin.readline

N = int(input())
numbers = list(int(input()) for _ in range(N))
answer = []
leftHeap = [] # maxHeap
rightHeap = [] # minHeap
middleValue = numbers[0]
answer.append(middleValue)
for i in range(1, len(numbers)):
    number = numbers[i]
    if i % 2 == 1: # 좌 우 heap의 size 동일
        if number < middleValue:
            heapq.heappush(leftHeap, -number)
            heapq.heappush(rightHeap, middleValue)
            middleValue = -heapq.heappop(leftHeap)
        else:
            heapq.heappush(rightHeap, number)
    else: # leftHeap size + 1 = rightHeap size
        if number <= middleValue:
            heapq.heappush(leftHeap, -number)
        else:
            heapq.heappush(leftHeap, -middleValue)
            heapq.heappush(rightHeap, number)
            middleValue = heapq.heappop(rightHeap)

    answer.append(middleValue)
print('\n'.join(map(str, answer)))