n = int(input())
numbers = list(map(int, input().split()))

numbers.sort()
total = sum(numbers)
answer = 0
for number in numbers:
    total -= number
    answer += total * number

print(answer)