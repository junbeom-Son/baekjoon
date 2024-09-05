string = input()
counts = [0] * 26
for c in string:
    counts[ord(c) - ord('a')] += 1

print(' '.join(map(str, counts)))