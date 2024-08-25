import sys
input = sys.stdin.readline

def canMakePalindrome(n, counts):
    oddCount = 0
    for count in counts:
        isOddCount = count % 2 == 1
        if isOddCount:
            if n % 2 == 0:
                return False
            oddCount += 1
    return oddCount <= 1

def getMid(counts):
    for i in range(len(counts)):
        if counts[i] % 2 == 1:
            return chr(ord('A') + i)


def solution(n, counts):
    if not canMakePalindrome(n, counts):
        return "I'm Sorry Hansoo"
    mid = '.'
    prefix = []
    if n % 2 == 1:
        mid = getMid(counts)
    for i in range(len(counts)):
        for _ in range(counts[i] // 2):
            prefix.append(chr(ord('A') + i))
    answer = []
    answer.append(''.join(prefix))
    if n % 2 == 1:
        answer.append(mid)
    prefix.reverse()
    answer.append(''.join(prefix))
    return ''.join(answer)

name = list(input().rstrip())
counts = [0] * 26
for c in name:
    counts[ord(c) - ord('A')] += 1

print(solution(len(name), counts))