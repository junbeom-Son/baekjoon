import sys
input = sys.stdin.readline

def initializePrimeNumbers(max_number):
    is_prime = [True] * (max_number + 1)
    is_prime[0] = False
    is_prime[1] = False
    number = 2
    while number * number <= max_number:
        if not is_prime[number]:
            number += 1
            continue
        for i in range(number + number, max_number + 1, number):
            is_prime[i] = False
        number += 1
    return is_prime

def solution(number, is_prime):
    if number == 4:
        return '2 2'
    number1 = number // 2
    number2 = number1
    if number1 % 2 == 0:
        number1 -= 1
        number2 += 1
    while not is_prime[number1] or not is_prime[number2]:
        number1 -= 2
        number2 += 2
    return f'{number1} {number2}'
    

T = int(input())
numbers = list(int(input()) for _ in range(T))
max_number = max(numbers)
is_prime = initializePrimeNumbers(max_number)
answer = []
for number in numbers:
    answer.append(solution(number, is_prime))

print('\n'.join(answer))