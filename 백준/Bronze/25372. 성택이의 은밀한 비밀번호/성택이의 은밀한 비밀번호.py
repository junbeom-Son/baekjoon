import sys
input = sys.stdin.readline

n = int(input())
passwords = list(input().rstrip() for _ in range(n))
answers = []
for password in passwords:
    if 6 <= len(password) <= 9:
        answers.append('yes')
    else:
        answers.append('no')

print('\n'.join(answers))