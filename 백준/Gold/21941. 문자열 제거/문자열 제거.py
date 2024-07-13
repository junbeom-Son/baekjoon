import sys
input = sys.stdin.readline

def matches(index, substring, length):
    for i in range(length):
        if S[index - i] != substring[length - i - 1]:
            return False
    return True

S = '-' + input().rstrip()
M = int(input())
subStrings = [[' ', '0']] + list(input().split() for _ in range(M))
scores = [0] * (len(S))
for i in range(1, len(S)):
    scores[i] = scores[i - 1] + 1
    for substring, score in subStrings:
        length = len(substring)
        score = int(score)
        if i < length or score <= length:
            continue

        if matches(i, substring, length):
            scores[i] = max(scores[i], scores[i - length] + score)

print(scores[-1])