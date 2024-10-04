import sys
input = sys.stdin.readline

T = int(input())
answers = []
for _ in range(T):
    N = int(input())
    numbers1 = set(map(int, input().split()))
    M = int(input())
    numbers2 = list(map(int, input().split()))
    for number in numbers2:
        answers.append('1' if number in numbers1 else '0')

print('\n'.join(answers))