import sys
input = sys.stdin.readline

n = int(input())
cards = set(map(int, input().split()))
m = int(input())
queries = list(map(int, input().split()))
answer = []
for query in queries:
    answer.append('1' if query in cards else '0')

print(' '.join(answer))