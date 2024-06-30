import sys
input = sys.stdin.readline

answer = []
evenOdd = ['even', 'odd']
N = int(input())
numbers = [int(input()) for _ in range(N)]
for number in numbers:
    print(evenOdd[number % 2])