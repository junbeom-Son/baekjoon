import sys
input = sys.stdin.readline

T = int(input())
answer = []
for _ in range(T):
    J, N = map(int, input().split())
    boxes = []
    for _ in range(N):
        R, C = map(int, input().split())
        boxes.append(R * C)
    boxes.sort()
    count = 0
    while J > 0:
        J -= boxes.pop()
        count += 1
    answer.append(count)

print('\n'.join(map(str, answer)))