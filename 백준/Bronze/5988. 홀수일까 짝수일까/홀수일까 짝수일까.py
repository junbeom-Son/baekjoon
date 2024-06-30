import sys
input = sys.stdin.readline

answer = []
evenOdd = ['even', 'odd']
N = int(input())
numbers = [int(input()) for _ in range(N)]
for number in numbers:
    answer.append(evenOdd[number % 2])

print('\n'.join(answer))