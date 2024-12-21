import sys
input = sys.stdin.readline

def count_bits(initial_bitmap, x1, y1, x2, y2):
    counts = [0, 0]
    for i in range(x1, x2):
        for j in range(y1, y2):
            bit = initial_bitmap[i][j]
            counts[bit] += 1

    return counts

def can_compress(count, size, threshold):
    rate = count / size
    return rate >= threshold

def cover(compressed_bitmap, x1, y1, x2, y2, color):
    for i in range(x1, x2):
        for j in range(y1, y2):
            compressed_bitmap[i][j] = color

def compress(initial_bitmap, compressed_bitmap, x1, y1, x2, y2, length, threshold):
    counts = count_bits(initial_bitmap, x1, y1, x2, y2)
    if can_compress(max(counts), length * length, threshold):
        represent_bit = 0
        if counts[1] > counts[0]:
            represent_bit = 1
        cover(compressed_bitmap, x1, y1, x2, y2, represent_bit)
        return
    x_half = (x1 + x2) // 2
    y_half = (y1 + y2) // 2
    half_length = length // 2
    compress(initial_bitmap, compressed_bitmap, x1, y_half, x_half, y2, half_length, threshold)
    compress(initial_bitmap, compressed_bitmap, x1, y1, x_half, y_half, half_length, threshold)
    compress(initial_bitmap, compressed_bitmap, x_half, y1, x2, y_half, half_length, threshold)
    compress(initial_bitmap, compressed_bitmap, x_half, y_half, x2, y2, half_length, threshold)

stage = 1
while True:
    try:
        W, T = map(int, input().split())
        T *= 0.01
        initial_bitmap = list(list(map(int, input().rstrip())) for _ in range(W))
        print(f'Image {stage}:')
        compressed_bitmap = list(list(0 for _ in range(W)) for _ in range(W))
        compress(initial_bitmap, compressed_bitmap, 0, 0, W, W, W, T)
        print('\n'.join(''.join(map(str, row)) for row in compressed_bitmap))
        stage += 1
    except:
        break