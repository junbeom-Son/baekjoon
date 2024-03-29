import sys
input = sys.stdin.readline

def getPi():
    length = len(P)
    pi = [0] * length
    j = 0
    for i in range(1, length):
        while j > 0 and P[i] != P[j]:
            j = pi[j - 1]

        if P[i] == P[j]:
            j += 1
            pi[i] = j
    return pi

T = input().rstrip()
P = input().rstrip()
answers = []
pi = getPi()
n = len(T)
m = len(P)
j = 0
for i in range(n):
    while j > 0 and T[i] != P[j]:
        j = pi[j - 1]
    if T[i] == P[j]:
        if j == m - 1:
            answers.append(i - m + 2)
            j = pi[j]
        else:
            j += 1

print(len(answers))
print('\n'.join(map(str, answers)))