import sys
input = sys.stdin.readline

vowels = set(['a', 'e', 'i', 'o', 'u'])
word = input().rstrip()
count = 0
for c in word:
    if c in vowels:
        count += 1
print(count)