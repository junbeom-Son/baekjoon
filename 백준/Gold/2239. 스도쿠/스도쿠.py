sudoku = [list(map(int, list(input()))) for _ in range(9)]
rows = [[False for _ in range(10)] for _ in range(9)]
cols = [[False for _ in range(10)] for _ in range(9)]
boxes = [[False for _ in range(10)] for _ in range(9)]
blankCells = []
found = False

def fillCell(depth):
    if depth == length:
        global found
        found = True
        return
    x, y = blankCells[depth]
    box = findBox(x, y)
    for i in range(1, 10):
        if rows[x][i] or cols[y][i] or boxes[box][i]:
            continue
        rows[x][i] = True
        cols[y][i] = True
        boxes[box][i] = True
        sudoku[x][y] = i
        fillCell(depth + 1)
        if found:
            return
        rows[x][i] = False
        cols[y][i] = False
        boxes[box][i] = False
        sudoku[x][y] = 0

def findBox(i, j):
    return (i // 3) * 3 + (j // 3)

for i in range(9):
    for j in range(9):
        number = sudoku[i][j]
        if number == 0:
            blankCells.append([i ,j])
        else:
            rows[i][number] = True
            cols[j][number] = True
            box = findBox(i, j)
            boxes[box][number] = True

length = len(blankCells)
fillCell(0)
for i in range(9):
    print(''.join(map(str, sudoku[i])))