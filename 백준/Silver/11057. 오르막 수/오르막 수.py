N = int(input())
counts = [1] * 10
for i in range(N - 1):
    new_counts = [1] * 10
    for j in range(1, 10):
        new_counts[j] = (new_counts[j - 1] + counts[j]) % 10007
    counts = new_counts

print(sum(counts) % 10007)