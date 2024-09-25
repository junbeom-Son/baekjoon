import sys
input = sys.stdin.readline

N = int(input())
answer = list(input().rstrip())
for _ in range(N - 1):
    s = input().rstrip()
    for i in range(len(s)):
        if answer[i] == '?':
            continue
        if answer[i] != s[i]:
            answer[i] = '?'

print(''.join(answer))