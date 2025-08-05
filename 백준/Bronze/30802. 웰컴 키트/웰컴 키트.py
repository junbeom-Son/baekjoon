import sys
input = sys.stdin.readline

N = int(input())
tShirtSizes = list(map(int, input().split()))
T, P = map(int, input().split())
minTShirtBundle = 0
for tShirtSize in tShirtSizes:
    minTShirtBundle += tShirtSize // T
    if tShirtSize % T > 0:
        minTShirtBundle += 1

print(minTShirtBundle)
print(N // P, N % P)