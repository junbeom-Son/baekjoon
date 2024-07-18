import sys
input = sys.stdin.readline

answers = [0] * 3
numbers = list(map(int, input().split()))
numbers.sort()
orders = input().rstrip()
for i in range(3):
    answers[i] = numbers[ord(orders[i]) - ord('A')]

print(' '.join(map(str, answers)))