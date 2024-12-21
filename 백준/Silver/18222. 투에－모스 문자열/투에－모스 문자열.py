def find_previous_number(number):
    previous_number = 1
    next_number = 1
    while next_number < number:
        previous_number = next_number
        next_number <<= 1
    return previous_number


def solution(number):
    if number == 1:
        return 0
    count = 1
    previous_number = find_previous_number(number)
    count += solution(number - previous_number)
    return count

k = int(input())
print(solution(k) % 2)