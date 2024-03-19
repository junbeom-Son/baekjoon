import sys
input = sys.stdin.readline

def getAnswer():
    answer = 0
    if n < 3 or m < 3:
        for i in range(n):
            for j in range(m):
                if origin[i][j] != target[i][j]:
                    return -1
        return 0
    for i in range(n - 2):
        for j in range(m - 2):
            if origin[i][j] != target[i][j]:
                answer += 1
                for k in range(3):
                    for l in range(3):
                        origin[i + k][j + l] = '1' if origin[i + k][j + l] == '0' else '0'
        if origin[i][-1] != target[i][-1] or origin[i][-2] != target[i][-2]:
            return -1

    for i in range(n - 2, n):
        for j in range(m):
            if origin[i][j] != target[i][j]:
                return -1

    return answer

n, m = map(int, input().split())
origin = list(list(input().rstrip()) for _ in range(n))
target = list(list(input().rstrip()) for _ in range(n))
print(getAnswer())
