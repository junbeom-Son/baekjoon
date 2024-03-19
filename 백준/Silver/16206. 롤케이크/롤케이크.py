import sys
input = sys.stdin.readline

N, M = map(int, input().split())
cakes = list(map(int, input().split()))
cakes.sort(key = lambda x : (x % 10, x))
count = 0
i = 0
for i in range(N):
    if cakes[i] % 10 == 0:
        needs = (cakes[i] - 1) // 10
        if M >= needs:
            count += cakes[i] // 10
            M -= needs
        else:
            count += M
            break
    else:
        needs = cakes[i] // 10
        if M >= needs:
            count += cakes[i] // 10
            M -= needs
        else:
            count += M
            break

print(count)