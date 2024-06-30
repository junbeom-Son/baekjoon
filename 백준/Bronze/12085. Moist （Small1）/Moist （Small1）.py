import sys
input = sys.stdin.readline

def needToChange(names, index):
    for i in range(index-1, -1, -1):
        if names[i] > names[index]:
            return True
    return False

T = int(input())
answer = []
for t in range(1, T + 1):
    N = int(input())
    names = [input().rstrip() for _ in range(N)]
    cost = 0
    for i in range(1, N):
        if needToChange(names, i):
            cost += 1

    answer.append(f'Case #{t}: {cost}\n')

print(''.join(answer), end='')