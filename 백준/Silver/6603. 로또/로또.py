import sys
input = sys.stdin.readline

def solution(depth, numbers, selected, tmp, N, start):
    if depth == 6:
        test_case.append(' '.join(map(str, tmp)))
        return
    for i in range(start, N):
        target = 1 << i
        if (target & selected) == 0: # 선택되지 않음
            selected |= target
            tmp.append(numbers[i])
            solution(depth + 1, numbers, selected, tmp, N, i + 1)
            tmp.pop()
            selected ^= target

answer = []
while True:
    numbers = list(map(int, input().split()))
    if numbers[0] == 0:
        break
    test_case = []
    solution(0, numbers[1:], 0, [], numbers[0], 0)
    answer.append('\n'.join(test_case))

print('\n\n'.join(answer))