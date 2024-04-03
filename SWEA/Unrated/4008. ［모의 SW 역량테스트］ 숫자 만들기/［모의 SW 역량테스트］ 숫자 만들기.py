T = int(input())
answers = []
operatorMapper = ['+', '-', '*', '/']
INF = 100000001

def solution(depth, numbers, operators, selectedOperators, N, included, selectedKeys):
    if depth == N - 1:
        global maxAnswer, minAnswer
        result = calculate(numbers, N, selectedOperators)
        maxAnswer = max(maxAnswer, result)
        minAnswer = min(minAnswer, result)
        return
    for i in range(N - 1):
        if not included[i]:
            nextKey = ''.join(selectedOperators + [operators[i]])
            if nextKey not in selectedKeys:
                selectedKeys.add(nextKey)
                included[i] = True
                selectedOperators.append(operators[i])
                solution(depth + 1, numbers, operators, selectedOperators, N, included, selectedKeys)
                selectedOperators.pop()
                included[i] = False


def calculate(numbers, N, selectedOperators):
    result = numbers[0]
    for i in range(1, N):
        if selectedOperators[i - 1] == '+':
            result += numbers[i]
        elif selectedOperators[i - 1] == '-':
            result -= numbers[i]
        elif selectedOperators[i - 1] == '*':
            result *= numbers[i]
        else:
            if result < 0:
                result = -(-result // numbers[i])
            else:
                result //= numbers[i]

    return result

for t in range(1, T + 1):
    N = int(input())
    operatorCounts = list(map(int, input().split()))
    operators = []
    for i in range(4):
        for j in range(operatorCounts[i]):
            operators.append(operatorMapper[i])
    numbers = list(map(int, input().split()))
    maxAnswer, minAnswer = -INF, INF
    solution(0, numbers, operators, [], N, [False] * (N - 1), set())
    answers.append(f'#{t} {maxAnswer - minAnswer}')

print('\n'.join(answers))