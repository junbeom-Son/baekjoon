N = int(input())
numbers = list(map(int, input().split()))

def find_index(LIS, number, last):
    left = 0
    right = last
    target_index = last
    while left <= right:
        mid = (left + right) // 2
        if LIS[mid] < number:
            left = mid + 1
        else:
            right = mid - 1
            target_index = mid

    return target_index

INF = 100000000
length = 0
LIS = [INF] * N
LIS_index = [0] * N
LIS_previous = [0] * N
LIS[0] = numbers[0]
LIS_previous[0] = -1
length += 1
for i in range(1, N):
    last = length - 1
    number = numbers[i]
    if number > LIS[last]: # 마지막 숫자 보다 크면
        LIS[length] = number
        length += 1
        continue
    elif number <= LIS[0]: # 첫 번째 숫자보다 작으면
        LIS[0] = number
    else:
        target_index = find_index(LIS, number, last)
        LIS[target_index] = number

print(length)