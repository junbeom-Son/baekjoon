import sys
input = sys.stdin.readline

def all_same_bit(image, x1, y1, x2, y2):
    first_bit = image[x1][y1]
    for i in range(x1, x2):
        for j in range(y1, y2):
            if image[i][j] != first_bit:
                return False
    return True

def compress(image, x1, y1, x2, y2):
    length = 1
    if all_same_bit(image, x1, y1, x2, y2):
        return length + 1
    x_half = (x1 + x2) // 2
    y_half = (y1 + y2) // 2
    length += compress(image, x1, y1, x_half, y_half)
    length += compress(image, x1, y_half, x_half, y2)
    length += compress(image, x_half, y1, x2, y_half)
    length += compress(image, x_half, y_half, x2, y2)
    return length

L = int(input())
image = list(list(map(int, input().split())) for _ in range(L))
print(compress(image, 0, 0, L, L))