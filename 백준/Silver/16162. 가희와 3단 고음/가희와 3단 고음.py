import sys
input = sys.stdin.readline

N, A, D = map(int, input().split())
sounds = list(map(int, input().split()))
answer = 0
nextSound = A
for sound in sounds:
    if sound == nextSound:
        answer += 1
        nextSound += D

print(answer)