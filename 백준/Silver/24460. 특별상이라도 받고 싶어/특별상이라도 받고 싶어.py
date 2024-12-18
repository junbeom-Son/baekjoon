import sys
input = sys.stdin.readline

def draw(numbers, x1, x2, y1, y2, length):
    if length == 1:
        return numbers[x1][y1]
    picked = []
    x_half = (x1 + x2) // 2
    y_half = (y1 + y2) // 2
    half_length = length // 2
    picked.append(draw(numbers, x1, x_half, y1, y_half, half_length))
    picked.append(draw(numbers, x_half, x2, y1, y_half, half_length))
    picked.append(draw(numbers, x1, x_half, y_half, y2, half_length))
    picked.append(draw(numbers, x_half, x2, y_half, y2, half_length))

    picked.sort()
    return picked[1]

N = int(input())
numbers = list(list(map(int, input().split())) for _ in range(N))
print(draw(numbers, 0, N, 0, N, N))