import sys
input = sys.stdin.readline

N = int(input())
A = [0] + list(map(int, input().split()))
M = int(input())
quries = list(list(map(int, input().split())) for _ in range(M))
answers = []
isPalindrome = [[False for _ in range(N + 1)] for _ in range(N + 1)]
for i in range(1, N + 1):
    isPalindrome[i][i] = True

for i in range(1, N):
    if A[i] == A[i + 1]:
        isPalindrome[i][i + 1] = True

for r in range(2, N):
    for i in range(1, N - r + 1):
        if A[i] == A[i + r] and isPalindrome[i + 1][i + r - 1]:
            isPalindrome[i][i + r] = True

for s, e in quries:
    if isPalindrome[s][e]:
        answers.append('1')
    else:
        answers.append('0')

print('\n'.join(answers))