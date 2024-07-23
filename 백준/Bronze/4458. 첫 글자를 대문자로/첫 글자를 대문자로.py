import sys
input = sys.stdin.readline

n = int(input())
sentences = list(list(input().rstrip()) for _ in range(n))
answer = []
for i in range(n):
    sentences[i][0] = sentences[i][0].upper()
    answer.append(''.join(sentences[i]))

print('\n'.join(answer))