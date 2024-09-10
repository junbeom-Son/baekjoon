E, S, M = map(int, input().split())
earth, sun, moon = 15, 28, 19

while not (E == S == M):
    if E < S or E < M:
        E += earth
    elif S < E or S < M:
        S += sun
    elif M < E or M < S:
        M += moon

print(E)