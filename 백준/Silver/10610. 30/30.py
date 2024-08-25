def solution(numbers):
    if numbers[-1] != 0:
        return -1
    total = sum(numbers)
    if total % 3 != 0:
        return -1
    return ''.join(map(str, numbers))
    
numbers = list(map(int, list(input())))
numbers.sort()
numbers.reverse()
print(solution(numbers))