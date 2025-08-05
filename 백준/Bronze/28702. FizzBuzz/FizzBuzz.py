import sys
input = sys.stdin.readline

def getNextNumber():
    for i in range(3):
        if problems[i].isdigit():
            return int(problems[i]) + (3 - i)

def convertAnswer(number):
    if number % 3 == 0:
        if number % 5 == 0:
            return 'FizzBuzz'
        return 'Fizz'
    if number % 5 == 0:
        return 'Buzz'
    return number

problems = list(input().rstrip() for _ in range(3))
nextNumber = getNextNumber()
print(convertAnswer(nextNumber))