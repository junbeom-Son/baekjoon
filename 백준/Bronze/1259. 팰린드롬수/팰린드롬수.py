import sys
input = sys.stdin.readline

answer = []
while True:
    number = input().rstrip()
    if int(number) == 0:
        break
    isPalindrome = True
    for i in range(len(number) // 2):
        if number[i] != number[len(number) - i - 1]:
            isPalindrome = False
            break
    answer.append('yes' if isPalindrome else 'no')

print('\n'.join(answer))