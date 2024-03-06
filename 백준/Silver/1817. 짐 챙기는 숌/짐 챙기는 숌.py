from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
books = []
if N > 0:
    books = deque(map(int, input().split()))

count = 0
while books:
    weight = 0
    while books:
        if weight + books[0] <= M:
            weight += books.popleft()
        else:
            break
    count += 1
print(count)