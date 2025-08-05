import sys
input = sys.stdin.readline

N = int(input())
students = list(int(input()) for _ in range(N))

k = 1
while True:
    unit = 10 ** k
    idSet = set()
    for student in students:
        idSet.add(student % unit)
    if len(idSet) == N:
        break
    k += 1

print(k)