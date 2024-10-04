import sys
input = sys.stdin.readline

def get_count(B, number):
    left = 0
    right = len(B) - 1
    count = 0
    while left <= right:
        mid = (left + right) // 2
        if B[mid] < number:
            count = mid + 1
            left = mid + 1
        else:
            right = mid - 1
    return count

T = int(input())
answer = []
for _ in range(T):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    B.sort()
    counts = {}
    total = 0
    for number in A:
        if number in counts:
            total += counts[number]
        else:
            count = get_count(B, number)
            counts[number] = count
            total += count
    answer.append(str(total))

print('\n'.join(answer))