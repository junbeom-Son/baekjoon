n = int(input())
numbers = list(map(int, input().split()))
v = int(input())
answer = 0
for number in numbers:
    if number == v:
        answer += 1
print(answer)