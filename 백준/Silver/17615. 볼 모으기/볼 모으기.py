import sys
input = sys.stdin.readline

def getCount(start, end, direction):
    count = 0
    for i in range(start, end, direction):
        count += counts[i]
    return count

N = int(input())
balls = input().rstrip()
counts = [1]
for i in range(1, N):
    if balls[i] == balls[i - 1]:
        counts[-1] += 1
    else:
        counts.append(1)

length = len(counts)
answer = getCount(length - 3, -1, -2)
answer = min(answer, getCount(length - 2, -1, -2))
answer = min(answer, getCount(2, length, 2))
answer = min(answer, getCount(1, length, 2))
print(answer)