import sys
input = sys.stdin.readline

def turn(depth, coins):
    global minCount
    if allSame(coins):
        minCount = min(minCount, depth)
        return
    if depth == 9:
        return
    for k in range(8):
        if not used[k]:
            used[k] = True
            for i in range(3):
                x = dx[k][i]
                y = dy[k][i]
                coins[x][y] = 'H' if coins[x][y] == 'T' else 'T'
            turn(depth + 1, coins)
            for i in range(3):
                x = dx[k][i]
                y = dy[k][i]
                coins[x][y] = 'H' if coins[x][y] == 'T' else 'T'
            used[k] = False



def allSame(coins):
    c = coins[0][0]
    for row in coins:
        for coin in row:
            if c != coin:
                return False
    return True

T = int(input())
dx = [[0, 0, 0], [1, 1, 1], [2, 2, 2], [0, 1, 2], [0, 1, 2], [0, 1, 2], [0, 1, 2], [0, 1, 2]]
dy = [[0, 1, 2], [0, 1, 2], [0, 1, 2], [0, 0, 0], [1, 1, 1], [2, 2, 2], [0, 1, 2], [2, 1, 0]]
used = [False] * 8

answer = []
for _ in range(T):
    coins = [list(input().split()) for _ in range(3)]
    minCount = int(1e9)
    turn(0, coins)
    if minCount == int(1e9):
        minCount = -1
    answer.append(minCount)

print('\n'.join(map(str, answer)))