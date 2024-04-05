from collections import deque
import sys
input = sys.stdin.readline

def isPalindromeNumbers(left, right):
    for i in range(len(left)):
        if left[-(i + 1)] != right[i]:
            return False
    return True

def getEvenPalindromeCount():
    left = deque()
    right = deque()
    count = 0
    while A:
        if not left:
            left.append(A.popleft())
            right.append(A.popleft())
        else:
            left.append(right.popleft())
            right.append(A.popleft())
            right.append(A.popleft())

        if isPalindromeNumbers(left, right):
            count += 1
            left.clear()
            right.clear()

    if left:
        return -1
    return count

N = int(input())
A = deque(map(int, input().split()))
print(getEvenPalindromeCount())