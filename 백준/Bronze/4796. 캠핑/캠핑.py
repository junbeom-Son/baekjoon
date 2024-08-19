import sys
input = sys.stdin.readline

caseNumber = 1
answers = []
while True:
    L, P, V = map(int, input().split())
    if L == P == V == 0:
        break
    count = V // P * L
    V %= P
    count += min(V, L)
    answers.append(f'Case {caseNumber}: {count}')
    caseNumber += 1

print('\n'.join(answers))