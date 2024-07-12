import sys
input = sys.stdin.readline

n = int(input())
sentences = list(input().rstrip() for _ in range(n))
for i in range(n):
    sentences[i] = ''.join([str(i + 1), '. ', sentences[i]])
print('\n'.join(sentences))