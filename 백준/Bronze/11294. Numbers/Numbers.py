A = ord('A')

def convert(base, number):
    result = []
    while number > 0:
        remainder = number % base
        if remainder < 10:
            result.append(str(remainder))
        else:
            result.append(chr(A + remainder - 10))
        number //= base

    return ''.join(reversed(result))

import sys
input = sys.stdin.readline
answers = []
while True:
    name = input().rstrip()
    if name == '#':
        break
    base = int(input())
    number = int(input())
    answers.append(', '.join([name, str(number), convert(base, number)]))

print('\n'.join(answers))