n = int(input())
left = 1
right = n
answer = n
while left <= right:
    mid = (left + right) // 2
    if mid * mid >= n:
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)