n, r, c = map(int, input().split())

def z(x1, y1, x2, y2, number):
    if x2 - 1 == x1 and y2 - 1 == y1:
        return number
    length = (x2 - x1) // 2
    if r < (x1 + x2) // 2: # 위쪽 인 경우
        if c < (y1 + y2) // 2: # 왼쪽인 경우
            return z(x1, y1, (x1 + x2) // 2, (y1 + y2) // 2, number)
        else: # 오른쪽인 경우
            return z(x1, (y1 + y2) // 2, (x1 + x2) // 2, y2, number + length ** 2)
    else: # 아래쪽인 경우
        if c < (y1 + y2) // 2: # 왼쪽인 경우
            return z((x1 + x2) // 2, y1, x2, (y1 + y2) // 2, number + (length ** 2) * 2)
        else: # 오른쪽인 경우
            return z((x1 + x2) // 2, (y1 + y2) // 2, x2, y2, number + (length ** 2) * 3)

n = 2**n
number = 0
print(z(0, 0, n, n, 0))

