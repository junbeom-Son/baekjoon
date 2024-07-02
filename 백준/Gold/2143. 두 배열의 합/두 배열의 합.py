import sys
input = sys.stdin.readline

def initailizeCounts(length, numbers):
    counts = dict() 
    for i in range(length):
        sum = 0
        for j in range(i, length):
            sum += numbers[j]
            counts[sum] = counts.get(sum, 0) + 1

    return counts


T = int(input())
n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))

aCounts = initailizeCounts(n, A)
bCounts = initailizeCounts(m, B)

answer = 0
for a in aCounts:
    answer += aCounts[a] * bCounts.get(T - a, 0)

print(answer)