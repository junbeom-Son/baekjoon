S = list(input())
T = list(input())
time = len(T) - len(S)
for _ in range(time):
    needToReverse = T[-1] == 'B'
    T.pop()
    if needToReverse:
        T.reverse()

isSame = True
for i in range(len(S)):
    if S[i] != T[i]:
        isSame = False

print(1 if isSame else 0)