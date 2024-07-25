T = int(input())
answers = []
for t in range(1, T + 1):
    position, count = input().split()
    count = int(count)
    counts = [[0 for _ in range(5)] for _ in range(int(count) + 1)]
    for i in range(3):
        if position[i] == 'o':
            counts[0][i + 1] = 1
    
    for i in range(1, count + 1):
        for j in range(1, 4):
            counts[i][j] = counts[i-1][j-1] + counts[i-1][j+1]

    result = counts[-1][1:4]
    answer = 0
    for i in range(1, 3):
        if result[i] > result[answer]:
            answer = i
    answers.append(f'#{t} {answer}')

print('\n'.join(answers))