number = int(input())

counts = [0] * 10
while number > 0:
    digit = number % 10
    if digit == 9:
        digit = 6
    counts[digit] += 1
    number //= 10

if counts[6] % 2 == 1:
    counts[6] += 1

counts[6], counts[9] = counts[6] // 2, counts[6] // 2
print(max(counts))