import sys
input = sys.stdin.readline

def swap_numbers(left, right, length, numbers):
    for i in range(length):
        numbers[left + i], numbers[right + i] = numbers[right + i], numbers[left + i]

def skewed_sort(left, right, N, numbers, cur_length):
    distance = 0
    if cur_length == 1:
        return 0
    mid = (left + right) // 2
    half_length = cur_length // 2
    distance += skewed_sort(left, mid, N, numbers, half_length)
    distance += skewed_sort(mid, right, N, numbers, half_length)
    if numbers[left] > numbers[mid]:
        swap_numbers(left, mid, half_length, numbers)
        distance += cur_length * half_length
    return distance

N = int(input())
N = 2**N
numbers = list(int(input()) for _ in range(N))
total_distances = skewed_sort(0, N, N, numbers, N)
answer = [total_distances] + numbers
print('\n'.join(map(str, answer)))