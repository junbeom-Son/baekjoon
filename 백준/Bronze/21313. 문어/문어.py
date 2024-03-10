n = int(input())
answer = [1, 2] * (n // 2)
if n % 2 == 1:
    answer.append(3)
print(' '.join(map(str, answer)))