import sys
input = sys.stdin.readline

def find(number):
    if groups[number] != number:
        groups[number] = find(groups[number])
    return groups[number]

def union(number1, number2):
    if number1 < number2:
        groups[number2] = number1
    else:
        groups[number1] = number2

n = int(input())
m = int(input())
lines = list(list(map(int, input().split())) for _ in range(m))
lines.sort(key = lambda x:x[2])
groups = [i for i in range(n + 1)]
answer = 0

for a, b, cost in lines:
    a = find(a)
    b = find(b)
    if a == b:
        continue
    union(a, b)
    answer += cost

print(answer)