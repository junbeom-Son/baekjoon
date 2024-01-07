expression = list(input())

def eliminateMultiplyAndDivision(expression):
    newExpression = []
    for i in range(len(expression)):
        newExpression.append(expression[i])
        if len(newExpression) > 2 and newExpression[-2] in ['/', '*']:
            operandB = newExpression.pop()
            operator = newExpression.pop()
            operandA = newExpression.pop()
            newExpression.append(operandA + operandB + operator)

    return newExpression

def eliminatePlusAndMinus(expression):
    newExpression = [expression[0]]
    for i in range(1, len(expression)):
        if expression[i] not in ['+', '-']:
            operator = newExpression.pop()
            newExpression.append(expression[i])
            newExpression.append(operator)
        else:
            newExpression.append(expression[i])

    return ''.join(newExpression)

def findCloseParenthesis(expression, index):
    count = 1
    for i in range(index, len(expression)):
        if expression[i] == '(':
            count += 1
        elif expression[i] == ')':
            count -=1
            if count == 0:
                return i

def solution(expression):
    newExpression = []
    i = 0
    while i < len(expression):
        if expression[i] == '(':
            closeParenthesisIndex = findCloseParenthesis(expression, i + 1)
            newExpression.append(solution(expression[i + 1 : closeParenthesisIndex]))
            i = closeParenthesisIndex
        else:
            newExpression.append(expression[i])
        i += 1

    newExpression = eliminateMultiplyAndDivision(newExpression)
    result = eliminatePlusAndMinus(newExpression)
    return result

print(solution(expression))