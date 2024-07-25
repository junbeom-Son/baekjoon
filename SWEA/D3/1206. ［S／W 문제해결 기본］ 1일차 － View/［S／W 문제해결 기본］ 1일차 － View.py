T = 10
answers = []
for t in range(1, T + 1):
    N = int(input())
    heights = list(map(int, input().split()))
    total = 0
    for i in range(2, N - 2):
        maxCount = heights[i]
        for j in range(-2, 3):
            if j == 0:
                continue
            count = heights[i] - heights[i+j]
            count = max(0, count)
            maxCount = min(maxCount, count)
        total += maxCount

    answers.append(f'#{t} {total}')

print('\n'.join(answers))