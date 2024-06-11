S = int(input())
answer = 1
left = 1
right = S
while left <= right:
    mid = (left + right) // 2
    sum = mid * (mid + 1) // 2
    if sum <= S:
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)