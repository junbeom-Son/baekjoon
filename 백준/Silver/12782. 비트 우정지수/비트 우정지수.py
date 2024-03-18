import sys
input = sys.stdin.readline

T = int(input())
answers = []
for _ in range(T):
    N, M = map(list, input().split())
    nCount, mCount, diffCount = 0, 0, 0
    for i in range(len(N)):
        if N[i] != M[i]:
            diffCount += 1
        if N[i] == '1':
            nCount += 1
        if M[i] == '1':
            mCount += 1

    answer = abs(nCount - mCount)
    diffCount -= answer
    answer += diffCount // 2
    if diffCount % 2 == 1:
        answer += 1
    answers.append(answer)

print('\n'.join(map(str, answers)))