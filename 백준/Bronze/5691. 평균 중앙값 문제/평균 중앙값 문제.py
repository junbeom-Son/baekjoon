import sys
input = sys.stdin.readline

answer = []
while True:
    numbers = list(map(int, input().split()))
    if numbers[0] == numbers[1] == 0:
        break
    numbers.sort()
    diff = numbers[1] - numbers[0]
    answer.append(str(numbers[0] - diff))

print('\n'.join(answer))