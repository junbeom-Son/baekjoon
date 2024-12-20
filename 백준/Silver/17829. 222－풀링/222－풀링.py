import sys
input = sys.stdin.readline

def extract_2nd_number(numbers, x, y):
    extracted_numbers = []
    for i in range(2):
        for j in range(2):
            extracted_numbers.append(numbers[x + i][y + j])

    extracted_numbers.sort()
    return extracted_numbers[2]

N = int(input())
numbers = list(list(map(int, input().split())) for _ in range(N))
while N > 1:
    tmp_numbers = []
    for i in range(0, N, 2):
        tmp_row = []
        for j in range(0, N, 2):
            extracted_number = extract_2nd_number(numbers, i, j)
            tmp_row.append(extracted_number)
        tmp_numbers.append(tmp_row)
    N //= 2
    numbers = tmp_numbers

print(numbers[0][0])